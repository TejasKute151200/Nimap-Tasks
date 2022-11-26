package com.springrestapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springrestapi.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

}
