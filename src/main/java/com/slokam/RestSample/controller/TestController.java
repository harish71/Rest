package com.slokam.RestSample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.RestSample.entity.Student;

@RestController
@RequestMapping("test")
public class TestController {

	// model and view vs responseentity
	
	// Response contains cookies, headers, body and response status
	
	@GetMapping("/student")
	public ResponseEntity<Student> getStudent(){
		Student std = new Student(1, "hello", "mca", 43534534L, 100);
		ResponseEntity<Student> re = new ResponseEntity<Student>(std,HttpStatus.OK);
		return re;
	}
	
	
	
}
