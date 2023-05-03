package com.Product.Backlog;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Product.Backlog.entity.Epic;
import com.Product.Backlog.entity.UserStory;
import com.Product.Backlog.helper.ProductHelper;
import com.Product.Backlog.repository.EpicRepository;
import com.Product.Backlog.repository.UserStoryRepsitory;
import com.Product.Backlog.service.Service;

@ExtendWith(MockitoExtension.class)
class ServiceTest {

	@InjectMocks
	private Service service;

	@Mock
	private EpicRepository epicRepo;

	@Mock
	private UserStoryRepsitory userStoryRepo;

	@Test
	void testCreateNewBacklog() {
		Epic epic = new Epic();
		UserStory userStory = new UserStory();
		ProductHelper helper = new ProductHelper();
		helper.setEpic(epic);
		helper.setStory(Arrays.asList(userStory));

		when(epicRepo.save(any(Epic.class))).thenReturn(epic);
		when(userStoryRepo.saveAll(any(List.class))).thenReturn(Arrays.asList(userStory));

		Boolean result = service.createNewBacklog(helper);

		assertThat(result).isTrue();
		verify(epicRepo, times(1)).save(any(Epic.class));
		verify(userStoryRepo, times(1)).saveAll(any(List.class));
	}

	@Test
	void testGetMyUserStory() {
		String developerId = "123";
		UserStory userStory1 = new UserStory();
		userStory1.setAssignedToDeveloperId(developerId);
		UserStory userStory2 = new UserStory();
		userStory2.setAssignedToDeveloperId("456");
		List<UserStory> list = Arrays.asList(userStory1, userStory2);

		when(userStoryRepo.findAll()).thenReturn(list);

		List<UserStory> result = service.getMyUserStory(developerId);

		assertThat(result.size()).isEqualTo(1);
		assertThat(result.get(0)).isEqualTo(userStory1);
		verify(userStoryRepo, times(1)).findAll();
	}

	@Test
	void testChangeStatus() {
		String id = "1";
		UserStory userStory = new UserStory();
		Optional<UserStory> opt = Optional.of(userStory);

		when(userStoryRepo.findById(anyInt())).thenReturn(opt);
		when(userStoryRepo.save(any(UserStory.class))).thenReturn(userStory);

		Boolean result = service.changeStatus(id, userStory);

		assertThat(result).isTrue();
		verify(userStoryRepo, times(1)).findById(anyInt());
		verify(userStoryRepo, times(1)).save(any(UserStory.class));
	}
}