package com.springrest.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;

import com.springrest.entity.Course;

public interface CourseService {
	
	public List<Course> getAllCourses(); // Read All
	public Course getCourse(long id);	// Read by id
	public Course saveCourse(Course course); // Create/Add new 
	public Course updateCourse(Course course); // Update
	public void deleteCourse(Long id); // Delete
	
	
}
