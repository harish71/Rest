package com.slokam.rest.controller;



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

import com.slokam.rest.entity.Student;
import com.slokam.rest.repo.Studentrrepo;



@RestController
@RequestMapping("/studentss")
public class StudentContrll {
	private static final Logger logger = LoggerFactory.getLogger(StudentContrll.class);

	
	@Autowired
	private Studentrrepo stdrepo;
	
	
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student std)
	{
		ResponseEntity<Student> re= new ResponseEntity<Student>(std,HttpStatus.OK);
		logger.debug(std.toString());
		stdrepo.save(std);
	logger.info("successfully save");
		return re;
	}
	//http://localhost:8080/studentss/23
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent( @PathVariable("id")Integer sid)
	{
		ResponseEntity<Student>rs=null;
		Optional<Student>opt=stdrepo.findById(sid);
		//optional didnt give any error incase data not presnt
		if(opt.isPresent())
		{
			logger.debug("data available");
			rs=new ResponseEntity<Student>(opt.get(),HttpStatus.OK);
		}
		else
		{
			logger.debug("data not available");
			rs=new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		return rs;
	}
	
	@RequestMapping("/all")
	public ResponseEntity<List<Student>> getAllstudents()
	{
		List<Student>stdlit=stdrepo.findAll();
		logger.debug("stdlit size :"+stdlit.size());
		ResponseEntity<List<Student>> re=new ResponseEntity<List<Student>>(stdlit,HttpStatus.OK);
		return re;
	}
	//http://localhost:8080/studentss/23
	@DeleteMapping("/{id}")
	public ResponseEntity<Student>deletStudent(@PathVariable("id")Integer did)
	{
		logger.debug("deleting stdunte id is:"+did);
		stdrepo.deleteById(did);
		logger.debug("deleting stdunte id is:"+did+"is success");
		return new ResponseEntity<Student>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
