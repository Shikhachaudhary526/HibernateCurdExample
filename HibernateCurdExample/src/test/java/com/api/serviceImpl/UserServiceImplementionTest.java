package com.api.serviceImpl;

import com.api.entity.StudentEntity;
import com.api.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplementionTest {
	@InjectMocks
	private UserServiceImplemention userServiceImplemention;
	private UserServiceImplemention mockUserServiceImplemention = mock(UserServiceImplemention.class);

	@Autowired
	private UserServiceImplemention obj;

	@Mock
	private StudentRepository studentRepository;

	@Test
	public void testUserName() {
		String userNameResponse = userServiceImplemention.userName("Pushkar");
		assertEquals("successful", userNameResponse);
	}

	@Test
	public void testSaveUser() {
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setId(10);
		studentEntity.setName("Pushkar");
		studentEntity.setAddress("Delhi");
		when(studentRepository.save(studentEntity)).thenReturn(studentEntity);
		StudentEntity userNameResponse = userServiceImplemention.saveUser(studentEntity);
		assertEquals("Pushkar", userNameResponse.getName());
	}

	@Test
	public void testGetUser(){

        /*List<StudentEntity> list = new ArrayList<>();
		list.add(new StudentEntity(11,"Shikha","Delhi"));
		list.add(new StudentEntity(12,"Pushkar","Ghaziabad"));

		Mockito.when(studentRepository.findAll()).thenReturn(list);
		List<StudentEntity> responseList = userServiceImplemention.getUser();

		assertEquals(list, responseList);*/

		StudentEntity entity = new StudentEntity();
		entity.setId(1);
		entity.setName("Shalu");
		entity.setAddress("lucknow");

		List<StudentEntity> entityList = new ArrayList<>();
		//entityList.add(entity);
		when(studentRepository.findAll()).thenReturn(entityList);
		List<StudentEntity> responseList1 = userServiceImplemention.getUser();
		assertEquals(entityList,responseList1);
	}



	@Test
	public void testUpdateUser(){
		StudentEntity entity = new StudentEntity();
		entity.setId(1);
		entity.setName("Shikha");
		entity.setAddress("Delhi");
		when(studentRepository.findById(entity.getId())).thenReturn(Optional.of(entity));
		when(studentRepository.save(entity)).thenReturn(entity);
		StudentEntity studentEntity = userServiceImplemention.updateUser(entity, entity.getId());
		assertEquals("Shikha",studentEntity.getName());
		System.out.println((""));
	}

	@Test
	public void testDeleteUser(){
		StudentEntity entity = new StudentEntity();
		entity.setId(1);
		when(studentRepository.findById(entity.getId())).thenReturn(Optional.of(entity));
		userServiceImplemention.deleteUser(1);
		verify(studentRepository, times(1)).delete(entity);

	}
}
