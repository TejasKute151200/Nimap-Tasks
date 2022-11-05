package com.springrestapi.service.impl;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springrestapi.entity.Student;
import com.springrestapi.repo.StudentRepo;
import com.springrestapi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo repo;

	@Override
	public List<Student> findAllByPage(Integer pageNumber, Integer pageSize) {
		
		Pageable p = PageRequest.of(pageNumber-1, pageSize);
		 
		 Page<Student> page = repo.findAll(p);
		 
		 List<Student> list = page.getContent() ;
		
		return list;
	}
	
	@Override
	public List<Student> findAll() {
		return repo.findAll();
	}
	
	@Override
	public Optional<Student> findById(long id) {

		return repo.findById(id);
	}

	@Override
	public Student saveStudent(Student s) {
		Student newStudent = new Student();
		newStudent.setName(s.getName());
		return repo.save(s);
	}

	@Override
	public Optional<Student> updateStudent(long id) {
		Optional<Student> student = repo.findById(id);
		return student;
	}

	@Override
	public void deleteById(long id) {
			 repo.deleteById(id);
	}
}
