package com.springrestapi.repo;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrestapi.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{


//	public Optional<Student> findByName(String name);
//	public Optional<Student> findByAddress(String address);

	

}
 