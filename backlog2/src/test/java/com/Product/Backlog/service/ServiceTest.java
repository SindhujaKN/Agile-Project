package com.Product.Backlog.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Product.Backlog.entity.Epic;
import com.Product.Backlog.entity.UserStory;
import com.Product.Backlog.helper.ProductHelper;
import com.Product.Backlog.repository.EpicRepository;
import com.Product.Backlog.repository.UserStoryRepsitory;

class ServiceTest {

	@Mock
	private EpicRepository epicRepo;

	@Mock
	private UserStoryRepsitory userStoryRepo;

	@InjectMocks
	private Service service;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCreateNewBacklog() {
	    Epic epic = new Epic();
	    epic.setName("Epic1");
	    epic.setProjectCode(1);

	    UserStory story1 = new UserStory();
	    story1.setName("Story1");
	    story1.setDescription("As a user, I want to be able to create an account, so that I can access the platform");
	    story1.setPriority(1);
	    story1.setEpic(epic);

	    UserStory story2 = new UserStory();
	    story2.setName("Story2");
	    story2.setDescription("As a user, I want to be able to upload a profile picture, so that others can see what I look like");
	    story2.setPriority(2);
	    story2.setEpic(epic);

	    ProductHelper helper = new ProductHelper();
	    helper.setEpic(epic);
	    helper.setStory(Arrays.asList(story1, story2));

	    Service service = new Service();
	}
	/*@Test
	void testCreateNewBacklog() {
		// Arrange
		Epic epic = new Epic();
		UserStory story = new UserStory();
		List<UserStory> stories = new ArrayList<>();
		stories.add(story);
		ProductHelper helper = new ProductHelper();
		helper.setEpic(epic);
		helper.setStory(stories);
		doNothing().when(epicRepo).save(epic);
		doNothing().when(userStoryRepo).saveAll(stories);

		// Act
		Boolean result = service.createNewBacklog(helper);

		// Assert
		verify(epicRepo, times(1)).save(epic);
		verify(userStoryRepo, times(1)).saveAll(stories);
		assertTrue(result);
	}*/
	
	/*@Test
	void testGetMyUserStory() {
		// Arrange
		String developerId = "1";
		UserStory story1 = new UserStory();
		story1.setAssignedToDeveloperId(developerId);
		UserStory story2 = new UserStory();
		List<UserStory> stories = new ArrayList<>();
		stories.add(story1);
		stories.add(story2);
		when(userStoryRepo.findAll()).thenReturn(stories);

		// Act
		List<UserStory> result = service.getMyUserStory(developerId);

		// Assert
		verify(userStoryRepo, times(1)).findAll();
		assertEquals(1, result.size());
		assertEquals(story1, result.get(0));
	}*/

	/*@Test
	void testChangeStatus() {
		// Arrange
		String id = "1";
		UserStory userStory = new UserStory();
		userStory.setId(1);
		Optional<UserStory> opt = Optional.of(userStory);
		when(userStoryRepo.findById(anyInt())).thenReturn(opt);
		doNothing().when(userStoryRepo).save(userStory);

		// Act
		Boolean result = service.changeStatus(id, userStory);

		// Assert
		verify(userStoryRepo, times(1)).findById(1);
		verify(userStoryRepo, times(1)).save(userStory);
		assertTrue(result);
	}*/

	@Test
	void testChangeStatusNotFound() {
		// Arrange
		String id = "1";
		UserStory userStory = new UserStory();
		userStory.setId(1);
		Optional<UserStory> opt = Optional.empty();
		when(userStoryRepo.findById(anyInt())).thenReturn(opt);

		// Act
		Boolean result = service.changeStatus(id, userStory);

		// Assert
		verify(userStoryRepo, times(1)).findById(1);
		verify(userStoryRepo, times(0)).save(userStory);
		assertFalse(result);
	}

/*@Test
public void testViewBackLog() {
    // Create a list of epics to return from the repository
    List<Epic> epicList = new ArrayList<>();
    Epic epic1 = new Epic();
    epic1.setId(1);
    epic1.setName("Epic 1");
    epic1.setProjectCode(123);
    Epic epic2 = new Epic();
    epic2.setId(2);
    epic2.setName("Epic 2");
    epic2.setProjectCode(456);
    epicList.add(epic1);
    epicList.add(epic2);
    
    // Set up the mock repository to return the list of epics
    when(epicRepo.findAll()).thenReturn(epicList);
    
    // Call the method being tested
    List<Epic> result = service.viewBackLog("123");
    
    // Verify that the correct methods were called on the repository
    verify(epicRepo, times(1)).findAll();
    
    // Verify that the result is as expected
    assertEquals(1, result.size());
    assertEquals(epic1, result.get(0));
}*/

@Test
public void testViewUserStoryDetails() {
    // Create a user story to return from the repository
    UserStory userStory = new UserStory();
    userStory.setId(1);
    userStory.setTitle("User Story 1");
    userStory.setDescription("This is user story 1");
    
    // Set up the mock repository to return the user story when findById() is called
    when(userStoryRepo.findById(1)).thenReturn(Optional.of(userStory));
    
    // Call the method being tested
    UserStory result = service.viewUserStoryDetails("1");
    
    // Verify that the correct methods were called on the repository
    verify(userStoryRepo, times(1)).findById(1);
    
    // Verify that the result is as expected
    assertEquals(userStory, result);
}
@Test
public void testChangeStatusSuccess() {
    // Create a user story to save to the repository
    UserStory userStory = new UserStory();
    userStory.setId(1);
    userStory.setTitle("User Story 1");
    userStory.setDescription("This is user story 1");
    userStory.setStatus("In Progress");
    
    // Set up the mock repository to return an optional containing the user story
    when(userStoryRepo.findById(1)).thenReturn(Optional.of(userStory));
    
    // Call the method being tested
    Boolean result = service.changeStatus("1", userStory);
    
    // Verify that the correct methods were called on the repository
    verify(userStoryRepo, times(1)).findById(1);
    verify(userStoryRepo, times(1)).save(userStory);
    
    // Verify that the result is as expected
    assertTrue(result);
    assertEquals("In Progress", userStory.getStatus());
}

@Test
public void testChangeStatusFailure() {
    // Set up the mock repository to return an empty optional
    when(userStoryRepo.findById(1)).thenReturn(Optional.empty());
    
    // Call the method being tested
    Boolean result = service.changeStatus("1", new UserStory());
    
    // Verify that the correct methods were called on the repository
    verify(userStoryRepo, times(1)).findById(1);
    verify(userStoryRepo, never()).save(any(UserStory.class));
    
    // Verify that the result is as expected
    assertFalse(result);
}
}
