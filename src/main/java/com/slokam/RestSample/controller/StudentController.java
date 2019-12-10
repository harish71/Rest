package com.slokam.RestSample.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.RestSample.entity.Student;
import com.slokam.RestSample.repo.StudentRepo;

@RestController
@RequestMapping("student")
public class StudentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentRepo studentRepo;
	
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student std){
		LOGGER.debug(std.toString());
		studentRepo.save(std);
		ResponseEntity<Student> re = new ResponseEntity<Student>(std,HttpStatus.OK);
		LOGGER.info("Successfully saved.");
		return re;		
	}
	
	//http://localhost:8080/student/23
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") Integer sid){
		ResponseEntity<Student> rs= null;
		Optional<Student> opt = studentRepo.findById(sid);
		if( opt.isPresent() ) {
			LOGGER.debug("Data Available");
			rs = new ResponseEntity<Student>(opt.get(),HttpStatus.OK);
		}else {
			LOGGER.debug("Data Not Available");
			rs =  new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		return rs;
	}
	
	@RequestMapping("/all")
	public ResponseEntity<List<Student>> getAllStudents(){
		    
		    List<Student> stdList =  studentRepo.findAll();
		    LOGGER.debug("stdList size::"+stdList.size());  
		    ResponseEntity<List<Student>> re =
		    		new ResponseEntity<List<Student>>(stdList,HttpStatus.OK);
		  return re;
	}
	//http://localhost:8080/student/23
	@DeleteMapping("/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") Integer id){
		   LOGGER.debug("Deleting Student with the id ::"+id);  
		   studentRepo.deleteById(id);
		   LOGGER.debug("Deleting Student with the id ::"+id + "is success");  
		return new ResponseEntity<Student>(HttpStatus.OK);
	}
	
	
	
	
}
