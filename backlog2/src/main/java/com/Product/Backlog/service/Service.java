package com.Product.Backlog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.Product.Backlog.entity.Epic;
import com.Product.Backlog.entity.UserStory;
import com.Product.Backlog.helper.ProductHelper;
import com.Product.Backlog.repository.EpicRepository;
import com.Product.Backlog.repository.UserStoryRepsitory;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	private EpicRepository epicRepo;

	@Autowired
	private UserStoryRepsitory userStoryRepo;

	public Boolean createNewBacklog(ProductHelper helper) {
		
		try {
			epicRepo.save(helper.getEpic());
			userStoryRepo.saveAll(helper.getStory());

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<UserStory> getMyUserStory(String developerId) {
		List<UserStory> list = new ArrayList<>();
		userStoryRepo.findAll().forEach(list::add);
		list = list.stream().filter(i -> i.getAssignedToDeveloperId().equalsIgnoreCase(developerId))
				.collect(Collectors.toList());

		return list;

	}

	public Boolean changeStatus(String id, UserStory userStory) {
		try {
			userStory.setId(Integer.parseInt(id));
			Optional<UserStory> opt = userStoryRepo.findById(Integer.parseInt(id));
			if (!opt.isEmpty()) {
				userStoryRepo.save(userStory);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/* public List<Epic> viewBackLog(String projectId) {
		List<Epic> list = new ArrayList<>();
		try {
			epicRepo.findAll().forEach(list::add);
			list = list.stream().filter(i -> i.getProjectCode().equals(Integer.parseInt(projectId)))
					.collect(Collectors.toList());
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}

	} */

	public UserStory viewUserStoryDetails(String userStoryId) {
		// List<UserStory> list = new ArrayList<>();
		return userStoryRepo.findById(Integer.parseInt(userStoryId)).get();

	}
    
	public List<Epic> getReport(int projectCode) {
		Boolean b=epicRepo.findByProjectId(projectCode);
		if(b==true)
		{
		return epicRepo.getProject(projectCode);
				
		}
		else
		{
			return null;
		}
	}
} 
