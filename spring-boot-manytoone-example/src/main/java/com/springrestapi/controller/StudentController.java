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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springrestapi.entity.Student;
import com.springrestapi.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/")
	public List<Student> getAllStudents() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Student> getById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping("/")
	public Student saveStudent(@RequestBody Student student) {
		return service.saveStudent(student);		
	}
	
	@PutMapping("/{id}")
	public void updateStudent(@PathVariable(value = "id") Long id,@RequestBody Student student) throws Exception {
		service.updateStudent(student,id);
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable long id) {
		 service.deleteById(id);
		 
	}
}
