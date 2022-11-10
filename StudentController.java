package com.springrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.dto.StudentDto;
import com.springrestapi.entity.Student;
import com.springrestapi.response.ErrorResponse;
import com.springrestapi.response.SuccessResponse;
import com.springrestapi.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/dto")
	public ResponseEntity<?> getAllByStudentDto() {

		List<StudentDto> dto = service.findByAllUsingDto();
		return new ResponseEntity<Object>(new SuccessResponse("Get All Student Data", "READ", HttpStatus.FOUND, dto),
				HttpStatus.FOUND);

	}

	@GetMapping("/dto/{id}")
	public ResponseEntity<?> getByDtoId(@PathVariable Long id) throws Exception {

		StudentDto studentDto = service.findByIdUsingDto(id);

		try {
			return new ResponseEntity<>(
					new SuccessResponse("Get Data By ID No. " + id, "READ", HttpStatus.FOUND, studentDto),
					HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND, "No." + id + " Id Doesn't Exist"),
					HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/student")
	public ResponseEntity<?> getAllByStudent() {

		return new ResponseEntity<>(
				new SuccessResponse("Get All Student Data", "READ", HttpStatus.FOUND, service.findAll()),
				HttpStatus.FOUND);
	}

	@GetMapping("/student/{pageNumber}/{pageSize}")
	public ResponseEntity<?> getAllStudent(@RequestParam(value = "pageNumber") Integer pageNumber,
			@RequestParam(value = "pageSize") Integer pageSize) {

		List<Student> getAll = service.findAllByPage(pageNumber, pageSize);

		return new ResponseEntity<>(new SuccessResponse("Get All Student Data", "READ", HttpStatus.FOUND, getAll),
				HttpStatus.FOUND);
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		service.findById(id);
		try {
			return new ResponseEntity<>(
					new SuccessResponse("Get Data By ID No. " + id, "READ", HttpStatus.FOUND, service.findById(id)),
					HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND, "No." + id + " Id Doesn't Exist"),
					HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/student/desc")
	public ResponseEntity<?> getAllOrderByDesc() {

		List<Student> student = service.getAllOrderByDesc();

		return new ResponseEntity<>(new SuccessResponse("Get Data By DESCENDING Order", "READ", HttpStatus.OK, student),
				HttpStatus.OK);
	}

	@PostMapping("/student")
	public ResponseEntity<?> saveStudent(@RequestBody Student student) {
		service.saveStudent(student);
		try {
			return new ResponseEntity<>(
					new SuccessResponse("Post New Student Data", "CREATE", HttpStatus.OK, service.saveStudent(student)),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST, "Id Already Exist"),
					HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/student/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable(value = "id") Long id, @RequestBody Student student)
			throws Exception {
		service.updateStudent(student, id);
		try {
			return new ResponseEntity<>(new SuccessResponse("Update Student Data ID No. " + id, "UPDATE", HttpStatus.OK,
					service.updateStudent(student, id)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND, "No." + id + " Id Doesn't Exist"),
					HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable long id) {
		service.deleteById(id);
		try {
			return new ResponseEntity<>(new SuccessResponse("Delete Student Data ID No. " + id, "DELETE", HttpStatus.OK,
					"Id " + id + " Deleted Successfully"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND, "No." + id + " Id Doesn't Exist"),
					HttpStatus.NOT_FOUND);
		}
	}

//	@GetMapping("/dto")
//	public List<StudentDto> getAllByStudentDto() {
//		
//		List<StudentDto> dto = service.findByAllUsingDto();
//		return dto;
//		
//	}
//	
//	@GetMapping("/dto/{id}")
//	public StudentDto getByDtoId(@PathVariable Long id) throws Exception {
//		
//		StudentDto studentDto= service.findByIdUsingDto(id);
//		
//		return studentDto;
//		
//	}
//	
//	@GetMapping("/student/{pageNumber}/{pageSize}")
//	public List<Student> getAllStudent(@RequestParam(value = "pageNumber") Integer pageNumber,
//										@RequestParam(value = "pageSize") Integer pageSize) {
//		
//		List<Student> getAll = 	service.findAllByPage(pageNumber, pageSize);
//		
//			return getAll;
//		}
//
//	@GetMapping("/student")
//	public List<Student> getAllByStudent() {
//		return service.findAll();
//	}
//	
//	
//	@GetMapping("/student/{id}")
//	public Optional<Student> getById(@PathVariable Long id) {
//		return service.findById(id);
//	}
//	
//	@GetMapping("/student/desc")
//	public List<Student> getAllOrderByDesc() {
//
//		List<Student> student = service.getAllOrderByDesc();
//
//		return student;
//	}
//
//	@PostMapping("/student")
//	public Student saveStudent(@RequestBody Student student) {
//		return service.saveStudent(student);
//		
//	}
//	
//	@PutMapping("/student/{id}")
//	public void updateStudent(@PathVariable(value = "id") Long id,@RequestBody Student student) throws Exception {
//		service.updateStudent(student,id);
//	}
//
//	@DeleteMapping("/student/{id}")
//	public void deleteStudent(@PathVariable long id) {
//		 service.deleteById(id);
//		 
//	}
}
