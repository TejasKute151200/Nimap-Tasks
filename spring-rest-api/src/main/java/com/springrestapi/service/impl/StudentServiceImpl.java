package com.springrestapi.service.impl;

import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.springrestapi.dto.StudentDto;
import com.springrestapi.entity.Student;
import com.springrestapi.repo.StudentRepo;
import com.springrestapi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo repo;

	@Override
	public List<StudentDto> findByAllUsingDto() {
		List<Student> student = repo.findAll();
		List<StudentDto> dto = new ArrayList<>();

		for (int i = 0; i < student.size(); i++) {
			StudentDto studentDto = new StudentDto();
			studentDto.setId(student.get(i).getId());
			studentDto.setName(student.get(i).getName());
			dto.add(studentDto);
		}
		return dto;
	}

	@Override
	public StudentDto findByIdUsingDto(Long id) throws Exception {

		Student student = repo.findById(id).orElseThrow(() -> new Exception());
		StudentDto studentDto = new StudentDto();
		studentDto.setId(student.getId());
		studentDto.setName(student.getName());

		return studentDto;

	}

	@Override
	public List<Student> findAll() {
		return repo.findAll();
	}

	@Override
	public List<Student> findAllByPage(Integer pageNumber, Integer pageSize) {

		Pageable p = PageRequest.of(pageNumber - 1, pageSize);

		Page<Student> page = repo.findAll(p);

		List<Student> list = page.getContent();

		return list;
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
	public Student updateStudent(Student student, Long id) throws Exception {

		Student studentUpdate = repo.findById(id).orElseThrow(() -> new Exception("Student Not Found"));
		studentUpdate.setName(student.getName());

		return repo.save(studentUpdate);
	}

	@Override
	public void deleteById(long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Student> getAllOrderByDesc() {

		List<Student> student = repo.findByOrderByIdDesc(Student.class);

		return student;
	}

//	@Override
//	public List<StudentDto> findByAllUsingDto(){
//	List<Student> student = repo.findAll();
//	List<StudentDto> dto = new ArrayList<>();
//	
//		for (int i = 0; i < student.size(); i++) {
//			StudentDto studentDto = new StudentDto();
//			studentDto.setId(student.get(i).getId());
//			studentDto.setName(student.get(i).getName());
//			dto.add(studentDto);
//		}
//		return dto;
//	}

//	@Override
//	public StudentDto findByIdUsingDto(Long id) throws Exception {
//		
//		Student student = repo.findById(id).orElseThrow(()-> new Exception());
//		StudentDto studentDto = new StudentDto();
//		studentDto.setId(student.getId());
//		studentDto.setName(student.getName());
//		
//		return studentDto;
//		
// }

//	@Override
//	public List<Student> findAllByPage(Integer pageNumber, Integer pageSize) {
//		
//		Pageable p = PageRequest.of(pageNumber-1, pageSize);
//		 
//		 Page<Student> page = repo.findAll(p);
//		 
//		 List<Student> list = page.getContent() ;
//		
//		return list;
//	}
//	
//	@Override
//	public List<Student> findAll() {
//		return repo.findAll();
//	}
//	
//	@Override
//	public Optional<Student> findById(long id) {
//
//		return repo.findById(id);
//	}
//	
//	@Override
//	public Student saveStudent(Student s) {
//		Student newStudent = new Student();
//		newStudent.setName(s.getName());
//		return repo.save(s);
//	}
//
//	@Override
//	public void updateStudent(Student student ,Long id)throws Exception {
//		
//		Student studentUpdate = repo.findById(id).orElseThrow(() -> new Exception("Student Not Found"));
//		studentUpdate.setName(student.getName());
//		 repo.save(studentUpdate);
//	}
//
//	@Override
//	public void deleteById(long id) {
//			 repo.deleteById(id);
//	}
//
//	@Override
//	public List<Student> getAllOrderByDesc() {
//
//		List<Student> student = repo.findByOrderByIdDesc(Student.class);
//
//		return student;
//	}

}
