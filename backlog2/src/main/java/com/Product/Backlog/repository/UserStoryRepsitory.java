package com.Product.Backlog.repository;

import org.springframework.data.repository.CrudRepository;

import com.Product.Backlog.entity.UserStory;

public interface UserStoryRepsitory extends CrudRepository<UserStory, Integer> {
	 //User story is entity and Integer data type of primary key of user story.
	

}
