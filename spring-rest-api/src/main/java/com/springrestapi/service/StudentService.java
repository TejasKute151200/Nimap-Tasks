package com.springrestapi.service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestapi.entity.Student;
import com.springrestapi.repo.StudentRepo;

public interface StudentService {

	public List<Student> findAll();

	public Optional<Student> findById(long id); 
	
	public Student saveStudent(Student s);

	public Optional<Student> updateStudent(long id);
	
	public void deleteById(long id);

//	public List<Student> findAllByPage();

	public List<Student> findAllByPage(Integer pageNumber, Integer pageSize);

}
