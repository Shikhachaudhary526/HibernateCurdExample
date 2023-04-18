package com.api.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entity.StudentEntity;
import com.api.repository.StudentRepository;
import com.api.service.UserService;

@Service
public class UserServiceImplemention implements UserService {

	@Autowired
	private StudentRepository repository;
	
	@Override
	public String userName(String state) {
		return "successful";
	}

	@Override
	public StudentEntity saveUser(StudentEntity student) {
		StudentEntity user = repository.save(student);
		return user;
	}

	@Override
	public List<StudentEntity> getUser() {
		List<StudentEntity> user = repository.findAll();
		return user;
	}

	@Override
	public void deleteUser(int id) {
		Optional<StudentEntity> user = repository.findById(id);
		if(user.isPresent()) {
			StudentEntity deleteUser = user.get();
			repository.delete(deleteUser);
		}
	
	}

	@Override
	public StudentEntity updateUser(StudentEntity student, Integer id) {
		
		Optional<StudentEntity> savedUser = repository.findById(id);
		StudentEntity updateUser  = savedUser.get();
		updateUser = repository.save(student);
		return updateUser;
	}

}
