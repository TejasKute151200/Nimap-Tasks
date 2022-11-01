package com.springrestapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrestapi.entity.Student;

@Repository
public interface MyRepo extends JpaRepository<Student, Long>{

}
 