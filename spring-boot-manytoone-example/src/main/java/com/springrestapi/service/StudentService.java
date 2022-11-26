package com.springrestapi.service;

import java.util.List;
import java.util.Optional;
import com.springrestapi.entity.Student;

public interface StudentService {

	public List<Student> findAll();

	public Optional<Student> findById(long id);

	public Student updateStudent(Student student, Long id) throws Exception;

	public void deleteById(long id);

	public Student saveStudent(Student student);

}
