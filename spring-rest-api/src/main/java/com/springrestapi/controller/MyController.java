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

import com.springrestapi.service.MyService;

@RestController
public class MyController {
	
	@Autowired
	private MyService service;

	@GetMapping("/get")
	public List<Student> getAllStudrnt() {
		return service.findAll();
	}
	
	@GetMapping("/get/id/{id}")
	public Optional<Student> getById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@GetMapping("/get/name/{name}")
	public Optional<Student> getByName(@PathVariable String name ){
		return service.findByName(name);
	}
	
	@GetMapping("/get/address/{name}")
	public Optional<Student> getByAddress(@PathVariable String address){
		return service.findByAddress(address);
	}

	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student s) {
		return service.saveStudent(s);
		
	}
	
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student s) {
		return service.updateStudent(s);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		 service.deleteById(id);
		 return "Id number "+id+" Deleted";
		 
	}
}
