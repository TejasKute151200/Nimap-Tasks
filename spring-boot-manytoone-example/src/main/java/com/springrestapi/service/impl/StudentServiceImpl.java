package com.springrestapi.service.impl;

import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.springrestapi.entity.Student;
import com.springrestapi.repo.StudentRepo;
import com.springrestapi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo repo;

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
		newStudent.setStudentId(s.getStudentId());
		newStudent.setStudentName(s.getStudentName());
		newStudent.setBook(s.getBook());
		
		return repo.save(newStudent);
	} 

	@Override
	public Student updateStudent(Student student, Long id) throws Exception {

		Student studentUpdate = repo.findById(id).orElseThrow(() -> new Exception("Student Not Found"));
		studentUpdate.setStudentName(student.getStudentName());

		return repo.save(studentUpdate);
	}

	@Override
	public void deleteById(long id) {
		repo.deleteById(id);
	}
}
