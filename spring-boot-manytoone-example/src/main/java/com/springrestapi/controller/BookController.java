package com.springrestapi.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.entity.Book;
import com.springrestapi.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService service;

	@GetMapping("/")
	public List<Book> getAllBooks() {
		return service.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Optional<Book> getById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping("/")
	public Book saveBook(@RequestBody Book book) {
		return service.saveBook(book);
		
	}
	
	@PutMapping("/{id}")
	public void updateBook(@PathVariable(value = "id") Long id,@RequestBody Book book) throws Exception {
		service.updateBook(book,id);
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable long id) {
		 service.deleteById(id);
		 
	}
}
