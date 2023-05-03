package com.Product.Backlog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity   //JPA entity mapped to database table 
@Table(name = "user_story")  //table name entity is mapped to 
public class UserStory {

	@Id  //primary key of entity
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	Integer id;
	@Length(min = 10, message = "Title must be min length of 50")
	String title;
	@Length(min = 50, message = "User story Detail must be min length of 50")
	String userStoryDetails;
	@Length(min = 50, message = "Acceptance Criteria must be min length of 50")
	String acceptanceCriteria;
	String priority;
	Date createdOn;
	Date doneOn;
	String assignedToDeveloperId;
	Integer storyPoint;
	String status;
	@Column(name = "epic_id")
	Integer epicId;

	public UserStory() {  //constructor for initializing the attributes 

	}

	public UserStory( String title, String userStoryDetails, String acceptanceCriteria, String priority,
			Date createdOn, Date doneOn, String assignedToDeveloperId, Integer storyPoint, String status,
			Integer epicId) {
		super();
	
		this.title = title;
		this.userStoryDetails = userStoryDetails;
		this.acceptanceCriteria = acceptanceCriteria;
		this.priority = priority;
		this.createdOn = createdOn;
		this.doneOn = doneOn;
		this.assignedToDeveloperId = assignedToDeveloperId;
		this.storyPoint = storyPoint;
		this.status = status;
		this.epicId = epicId;
	}
    //getter and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserStoryDetails() {
		return userStoryDetails;
	}

	public void setUserStoryDetails(String userStoryDetails) {
		this.userStoryDetails = userStoryDetails;
	}

	public String getAcceptanceCriteria() {
		return acceptanceCriteria;
	}

	public void setAcceptanceCriteria(String acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getDoneOn() {
		return doneOn;
	}

	public void setDoneOn(Date doneOn) {
		this.doneOn = doneOn;
	}

	public String getAssignedToDeveloperId() {
		return assignedToDeveloperId;
	}

	public void setAssignedToDeveloperId(String assignedToDeveloperId) {
		this.assignedToDeveloperId = assignedToDeveloperId;
	}

	public Integer getStoryPoint() {
		return storyPoint;
	}

	public void setStoryPoint(Integer storyPoint) {
		this.storyPoint = storyPoint;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getEpicId() {
		return epicId;
	}

	public void setEpicId(Integer epicId) {
		this.epicId = epicId;
	}

	@Override
	public String toString() {
		return "UserStory [id=" + id + ", title=" + title + ", userStoryDetails=" + userStoryDetails
				+ ", acceptanceCriteria=" + acceptanceCriteria + ", priority=" + priority + ", createdOn=" + createdOn
				+ ", doneOn=" + doneOn + ", assignedToDeveloperId=" + assignedToDeveloperId + ", storyPoint="
				+ storyPoint + ", status=" + status + ", epicId=" + epicId + "]";
	}

	public void setDescription(String string) {
		// TODO Auto-generated method stub
		
		
		
	}

	public void setName(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setEpic(Epic epic) {
		// TODO Auto-generated method stub
		
	}

	public void setPriority(int i) {
		// TODO Auto-generated method stub
		
	}

}
