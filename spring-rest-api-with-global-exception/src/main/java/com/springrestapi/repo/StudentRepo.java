package com.springrestapi.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrestapi.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

	public List<Student> findByOrderByIdDesc(Class<Student> class1);

	public Optional<Student> findByNameContainingIgnoreCase(String name);

}
// Global Exception
// Validation