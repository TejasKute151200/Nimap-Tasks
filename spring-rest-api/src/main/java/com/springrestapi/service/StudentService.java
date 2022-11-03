package com.springrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestapi.entity.Student;
import com.springrestapi.repo.StudentRepo;

public interface StudentService {

	public List<Student> findAll();

	public Optional<Student> findById(Long id); 
	
	public Student saveStudent(Student s);

	public Student updateStudent(Student s);
	
	public void deleteById(Long id);

}
