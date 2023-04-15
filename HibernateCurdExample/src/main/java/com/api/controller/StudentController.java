package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.StudentEntity;
import com.api.serviceImpl.UserServiceImplemention;

@RestController
public class StudentController {
	
	
	@Autowired
	private UserServiceImplemention serviceimpl;
	
	@PostMapping("/saveData")
	public ResponseEntity<StudentEntity> saveUser(@RequestBody StudentEntity student){
		StudentEntity userResponse = serviceimpl.saveUser(student);
		return new ResponseEntity<>(userResponse, HttpStatus.OK);
	}
	
	@GetMapping("/useofService")
	public void getService() {
	  System.out.println(serviceimpl.userName("UP"));
	}
	
	@GetMapping("/getData")
	public List<StudentEntity> getData() {
		return serviceimpl.getUser();
	}
	
	@PutMapping("/updateData/{id}")
	public void updateData(@RequestBody StudentEntity student,  @PathVariable("id") Integer id) {
		serviceimpl.updateUser(student, id);
	}
	
	@DeleteMapping("/deleteData/{id}")
	public String deleteData(@PathVariable int id) {
		serviceimpl.deleteUser(id);
		return "id deleted successfully";
	}
}
