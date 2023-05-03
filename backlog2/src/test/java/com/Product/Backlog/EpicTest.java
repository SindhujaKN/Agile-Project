package com.Product.Backlog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Product.Backlog.entity.Epic;
import com.Product.Backlog.entity.UserStory;

@ExtendWith(MockitoExtension.class)
public class EpicTest {

    @Test
    public void testSetAndGetProjectCode() {
        Epic epic = new Epic();
        epic.setProjectCode(1234);
        assertEquals(1234, epic.getProjectCode());
    }

    @Test
    public void testSetAndGetSprintID() {
        Epic epic = new Epic();
        epic.setSprintID(1);
        assertEquals(1, epic.getSprintID());
    }

    @Test
    public void testSetAndGetName() {
        Epic epic = new Epic();
        epic.setName("Epic name");
        assertEquals("Epic name", epic.getName());
    }

    @Test
    public void testSetAndGetCreatedOn() {
        Epic epic = new Epic();
        Date date = new Date();
        epic.setCreatedOn(date);
        assertEquals(date, epic.getCreatedOn());
    }

    @Test
    public void testSetAndGetCompletedOn() {
        Epic epic = new Epic();
        Date date = new Date();
        epic.setCompletedOn(date);
        assertEquals(date, epic.getCompletedOn());
    }

    @Test
    public void testSetAndGetStatus() {
        Epic epic = new Epic();
        epic.setStatus("Open");
        assertEquals("Open", epic.getStatus());
    }

    @Test
    public void testSetAndGetUserStory() {
        Epic epic = new Epic();
        UserStory userStory1 = new UserStory();
        UserStory userStory2 = new UserStory();
        List<UserStory> userStoryList = new ArrayList<>();
        userStoryList.add(userStory1);
        userStoryList.add(userStory2);
        epic.setUserStory(userStoryList);
        assertEquals(userStoryList, epic.getUserStory());
    }
}