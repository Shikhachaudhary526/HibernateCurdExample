package com.api.service;

import java.util.List;

import com.api.entity.StudentEntity;

public interface UserService {
	
	public String userName(String state);
	
	public StudentEntity saveUser(StudentEntity student);
	
	public List<StudentEntity> getUser();
	
	public void deleteUser(int id);
	
	public StudentEntity updateUser(StudentEntity student, Integer id);

}
