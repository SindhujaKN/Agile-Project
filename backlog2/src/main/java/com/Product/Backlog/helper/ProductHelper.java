package com.Product.Backlog.helper;

import java.util.List;

import com.Product.Backlog.entity.Epic;
import com.Product.Backlog.entity.UserStory;

public class ProductHelper {

	Integer id;
	private Epic epic;
	private List<UserStory> story;

	public ProductHelper() {       //constructor 1

	}

	public ProductHelper(Integer id, Epic epic, List<UserStory> story) { //constructor 2
		super();
		this.id = id;
		this.epic = epic;
		this.story = story;
	}
    //getter and setter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Epic getEpic() {
		return epic;
	}

	public void setEpic(Epic epic) {
		this.epic = epic;
	}

	public List<UserStory> getStory() {
		return story;
	}

	public void setStory(List<UserStory> story) {
		this.story = story;
	}

	@Override
	public String toString() {
		return "ProductHelper [id=" + id + ", epic=" + epic + ", story=" + story + "]";
	}

}