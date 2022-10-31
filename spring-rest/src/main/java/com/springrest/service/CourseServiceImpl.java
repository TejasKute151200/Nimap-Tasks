package com.springrest.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.springrest.entity.Course;

@Service
public class CourseServiceImpl implements CourseService{
	
	List<Course> list;
	
	public CourseServiceImpl(){
		list= new ArrayList<>();
		list.add(new Course(345,"Tejas","Tejas"));
		list.add(new Course(546,"Kute","Kute"));
	}

	@Override
	public List<Course> getAllCourses() {
		
		return list;
	}

	@Override
	public Course getCourse(long id) {
		
		Course c=null;
		for (Course course:list) {
			if(course.getId()==id) {
				c=course;
				break;
			}
		}
		
		return c;
	}

	@Override
	public Course saveCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public void deleteCourse(Long id) {
		list = this.list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
		
	}
}

