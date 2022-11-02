package com.springrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestapi.entity.Student;
import com.springrestapi.repo.MyRepo;

@Service
public class MyServiceImpl implements MyService {

	@Autowired
	private MyRepo repo;

	@Override
	public List<Student> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<Student> findById(Long id) {

		return repo.findById(id);
	}

	@Override
	public Student saveStudent(Student s) {
		Student newStudent = new Student();
		newStudent.setName(s.getName());
		return repo.save(s);
	}

	@Override
	public Student updateStudent(Student s) {
		Student s1 = repo.findById(s.getId()).orElseThrow();
		s1.setName(s.getName());
		return repo.save(s1);

	}

	@Override
	public void deleteById(Long id) {
			 repo.deleteById(id);
	}

	@Override
	public Optional<Student> findByName(String name) {
		
		return repo.findByName(name);
	}

	@Override
	public Optional<Student> findByAddress(String address) {
		
		return repo.findByAddress(address);
	}
}
