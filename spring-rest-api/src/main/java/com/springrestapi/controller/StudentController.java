package com.springrestapi.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springrestapi.entity.Student;
import com.springrestapi.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/student/{pageNumber}/{pageSize}")
	public List<Student> getAllStudent(@PathVariable(value = "pageNumber") Integer pageNumber,
										@PathVariable(value = "pageSize") Integer pageSize) {
		
		List<Student> getAll = 	service.findAllByPage(pageNumber, pageSize);
		
			return getAll;
		}

	@GetMapping("/student")
	public List<Student> getAllByStudent() {
		return service.findAll();
	}
	
	@GetMapping("/student/{id}")
	public Optional<Student> getById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student student) {
		return service.saveStudent(student);
		
	}
	
	@PutMapping("/student/{id}")
	public Student updateStudent(@RequestBody Student s,@PathVariable Long id) {
		return service.saveStudent(s);
	}
	
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable Long id) {
		 service.deleteById(id);
		 return "Id number "+id+" Deleted";
		 
	}
}