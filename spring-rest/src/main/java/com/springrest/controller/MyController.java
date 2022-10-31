package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entity.Course;
import com.springrest.service.CourseService;

@RestController
public class MyController {
	
@Autowired
	private CourseService courseService;
	
	@GetMapping("/demo")
	public String Tejas() {
		return "This Is a Demo";
	}
	
	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		return this.courseService.getAllCourses();
		
	}
	
	@GetMapping("/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return this.courseService.getCourse(Long.parseLong(id));
	}
	
	@PostMapping("/courses")
	public Course saveCourse(@RequestBody Course course) {
		return this.courseService.saveCourse(course);
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable Long id) {
		this.courseService.deleteCourse(id);
	}
}
