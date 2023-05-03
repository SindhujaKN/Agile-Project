package com.Product.Backlog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Product.Backlog.entity.UserStory;

@ExtendWith(MockitoExtension.class)
public class UserStoryTest {

    @Mock
    private UserStory mockUserStory;
    
    private UserStory userStory;

    @BeforeEach
    public void setUp() throws Exception {
        userStory = new UserStory("Sample Title", "Sample User Story Details", "Sample Acceptance Criteria", "High", 
                new Date(), null, "Developer1", 3, "To Do", 1);
    }
    
    @Test
    public void testSetTitle() {
        userStory.setTitle("Updated Title");
        assertEquals("Updated Title", userStory.getTitle());
    }
    
    @Test
    public void testSetUserStoryDetails() {
        userStory.setUserStoryDetails("Updated User Story Details");
        assertEquals("Updated User Story Details", userStory.getUserStoryDetails());
    }
    
    @Test
    public void testSetAcceptanceCriteria() {
        userStory.setAcceptanceCriteria("Updated Acceptance Criteria");
        assertEquals("Updated Acceptance Criteria", userStory.getAcceptanceCriteria());
    }
    
    @Test
    public void testSetPriority() {
        userStory.setPriority("Low");
        assertEquals("Low", userStory.getPriority());
    }
    
    @Test
    public void testSetCreatedOn() {
        Date newDate = new Date();
        userStory.setCreatedOn(newDate);
        assertEquals(newDate, userStory.getCreatedOn());
    }
    
    @Test
    public void testSetDoneOn() {
        Date newDate = new Date();
        userStory.setDoneOn(newDate);
        assertEquals(newDate, userStory.getDoneOn());
    }
    
    @Test
    public void testSetAssignedToDeveloperId() {
        userStory.setAssignedToDeveloperId("Developer2");
        assertEquals("Developer2", userStory.getAssignedToDeveloperId());
    }
    
    @Test
    public void testSetStoryPoint() {
        userStory.setStoryPoint(5);
        assertEquals(5, userStory.getStoryPoint());
    }
    
    @Test
    public void testSetStatus() {
        userStory.setStatus("In Progress");
        assertEquals("In Progress", userStory.getStatus());
    }
    
    @Test
    public void testSetEpicId() {
        userStory.setEpicId(2);
        assertEquals(2, userStory.getEpicId());
    }
    
    @Test
    public void testToString() {
        String expectedString = "UserStory [id=null, title=Sample Title, userStoryDetails=Sample User Story Details, acceptanceCriteria=Sample Acceptance Criteria, priority=High, createdOn=" + userStory.getCreatedOn() + ", doneOn=null, assignedToDeveloperId=Developer1, storyPoint=3, status=To Do, epicId=1]";
        assertEquals(expectedString, userStory.toString());
    }
    
    @Test
    public void testSetDescription() {
        userStory.setDescription("Sample Description");
        verify(mockUserStory).setDescription(any(String.class));
    }
    
    @Test
    public void testSetName() {
        userStory.setName("Sample Name");
        verify(mockUserStory).setName(any(String.class));
    }
    
 }