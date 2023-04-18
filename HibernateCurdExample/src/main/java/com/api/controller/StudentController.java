package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.StudentEntity;
import com.api.service.UserService;

@RestController
public class StudentController {
	
	
	@Autowired
	private UserService userService;
	
	//@Autowired
	//private StudentRepository repo;
	
	@PostMapping("/saveData")
	public ResponseEntity<StudentEntity> saveUser(@RequestBody StudentEntity student){
		StudentEntity userResponse = userService.saveUser(student);
		return new ResponseEntity<>(userResponse, HttpStatus.OK);
	}
	
	@GetMapping("/useofService")
	public void getService() {
	  System.out.println(userService.userName("UP"));
	}
	
	@GetMapping("/getData")
	public List<StudentEntity> getData() {
		return userService.getUser();
	}
	
	@PutMapping("/updateData/{id}")
	public void updateData(@RequestBody StudentEntity student,  @PathVariable("id") Integer id) {
		userService.updateUser(student, id);
	}
	
	@DeleteMapping("/deleteData/{id}")
	public String deleteData(@PathVariable int id) {
		userService.deleteUser(id);
		return "id deleted successfully";
	}
	
	/*
	 * @GetMapping("/userExitsById/{id}") public ResponseEntity<StudentEntity>
	 * getStudentById(@PathVariable("id") Integer id) { StudentEntity student =
	 * repo.isStudentExitsById(id);
	 * 
	 * return new ResponseEntity<StudentEntity>(student, HttpStatus.OK);
	 * 
	 * }
	 */
}
