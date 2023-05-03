package com.Product.Backlog.controller;

import java.util.HashMap;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Product.Backlog.entity.Epic;
import com.Product.Backlog.entity.UserStory;
import com.Product.Backlog.helper.ProductHelper;
import com.Product.Backlog.service.Service;

@RestController   //restful API controller
@CrossOrigin(origins = "http://localhost:4200") //control access to resources
public class BacklogController {  // class with rest API end points 

	@Autowired
	private Service service;
	
/*	http://localhost:8085/productbacklog/create
 * 
 *{
		"epic": {
			"projectCode": 11,
			"sprintID": "6",
			"name": "epic1",
			"createdOn": "2023-05-11",
			"completedOn": "2023-05-31",
			"status": "Success"
		},
		"story": [{
			"title": "This is my title",
			"userStoryDetails": "Here we write detail of a user story and about the things need to be implemented",
			"acceptanceCriteria": "Here we write acceptance criteria of a user story and about the things need to be implemented",
			"priority": "1",
			"createdOn": "2023-11-11",
			"doneOn": "2023-11-11",
			"assignedToDeveloperId": "123",
			"storyPoint": "2",
			"status": "assigned",
			"epicId": "1"
		}]

	}*/
//POST to create new product backlog by taking JSON request body with epic object and user stories 
	@PostMapping(value = "/productbacklog/create")
	public HashMap<String, String> createNewProduct(@RequestBody ProductHelper productHelper) {
		HashMap<String, String> hmap = new HashMap<>();
		if (service.createNewBacklog(productHelper)) {
			hmap.put("message", "Success");

		} else {
			hmap.put("message", "Failure");
		}
		return hmap;
	}
//GET retrieves all User story assigned to specific developer
	//http://localhost:8085/prductbacklog/userstories/123
	@GetMapping(value = "/prductbacklog/userstories/{developerId}")
	public List<UserStory> getMyUserStory(@PathVariable("developerId") String developerId) {

		return service.getMyUserStory(developerId);

	}
//makes new entry
	/*
	http://localhost:8085/prductbacklog/updateUserStory/8
		
	{
		"title": "title1",
		"userStoryDetails": "detail of the user story should be noted by the developer",
		"acceptanceCriteria": "the password criteria must meet the password policy to be done",
		"priority": "1",
		"createdOn": "2023-11-11",
		"doneOn": "2023-11-11",
		"assignedToDeveloperId": "123",
		"storyPoint": "2",
		"status": "finished",
		"epicId": "2"
	}
	*/
    //PUT updates existing user story as ID and JSON request body
	@PutMapping(value = "/prductbacklog/updateUserStory/{id}")
	public HashMap<String, String> updateUserStory(@PathVariable("id") String id,@RequestBody UserStory userStory) {
		HashMap<String, String> hmap = new HashMap<>();
		
		if (service.changeStatus(id,userStory)) {
			hmap.put("message", "Success");

		} else {
			hmap.put("message", "Failure");
		}
		return hmap;

	}
	
	//http://localhost:8085/prductbacklog/report/45

	/*@GetMapping(value = "/prductbacklog/report/{projectId}")
	public List<Epic> viewProductBacklog(@PathVariable("projectId") String projectId) {
		return service.viewBackLog(projectId);
	}*/
	
	@GetMapping(value = "/prductbacklog/userstory/{userStoryID}")
	public UserStory viewUserStoryDetail(@PathVariable("userStoryID") String userStoryID) {
		return service.viewUserStoryDetails(userStoryID);
	}
	
	@GetMapping(value = "/prductbacklog/report/{projectId}")
    private ResponseEntity<List<Epic>> projectReportById(@PathVariable("projectId") int projectId)
    {
		List<Epic> defectDto=service.getReport(projectId);
		if(defectDto != null)
		{
			return new ResponseEntity <>(defectDto, HttpStatus.OK);
		}
		else {
			return new ResponseEntity (("{\"error\":\"" + "projectCode Not found" + "\")"),HttpStatus.NOT_FOUND);
			
		}
    }
}
