package com.springrestapi.service;

import java.util.List;
import java.util.Optional;

import com.springrestapi.dto.StudentDto;
import com.springrestapi.entity.Student;

public interface StudentService {

	public List<StudentDto> findByAllUsingDto();

	public StudentDto findByIdUsingDto(Long id) throws Exception;

	public List<Student> findAll();

	public List<Student> findAllByPage(Integer pageNumber, Integer pageSize);

	public Optional<Student> findById(long id);

	public Student updateStudent(Student student, Long id) throws Exception;

	public void deleteById(long id);

	public Student saveStudent(Student student);

	public List<Student> getAllOrderByDesc();

//	public List<StudentDto> findByAllUsingDto();
//
//	public StudentDto findByIdUsingDto(Long id) throws Exception;
//
//	public List<Student> findAll();
//
//	public Optional<Student> findById(long id); 
//
//	public void updateStudent(Student student,Long id) throws Exception;
//	
//	public void deleteById(long id);
//
//	public List<Student> findAllByPage(Integer pageNumber, Integer pageSize);
//
//	public Student saveStudent(Student student);
//	
//	public List<Student> getAllOrderByDesc();

}
