package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Student;
import com.springboot.repository.DynamoDbRepository;

@RestController
@RequestMapping("/dynamoDb")
public class DynamoDbController {

	@Autowired
	private DynamoDbRepository repository;

	@PostMapping
	public String insertIntoDynamoDB(@RequestBody Student student) {
		repository.insertIntoDynamoDB(student);
		return "Successfully inserted into DynamoDB table";
	}

	@GetMapping
	public ResponseEntity<Student> getOneStudentDetails(@RequestParam String studentId, @RequestParam String lastName) {
		Student student = repository.getOneStudentDetails(studentId, lastName);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@PutMapping
	public void updateStudentDetails(@RequestBody Student student) {
		repository.updateStudentDetails(student);
	}

	@DeleteMapping(value = "{studentId}/{lastName}")
	public void deleteStudentDetails(@PathVariable("studentId") String studentId,
			@PathVariable("lastName") String lastName) {
		Student student = new Student();
		student.setStudentId(studentId);
		student.setLastName(lastName);
		repository.deleteStudentDetails(student);
	}
}