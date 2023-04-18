package com.api.serviceImpl;

import static org.junit.Assert.*;

import com.api.entity.StudentEntity;
import com.api.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplementionTest {
	@InjectMocks
	private UserServiceImplemention userServiceImplemention;

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
		Mockito.when(studentRepository.save(studentEntity)).thenReturn(studentEntity);
		StudentEntity userNameResponse = userServiceImplemention.saveUser(studentEntity);
		assertEquals("Pushkar", userNameResponse.getName());
	}
	

}
