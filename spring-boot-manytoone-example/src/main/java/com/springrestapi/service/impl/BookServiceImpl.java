package com.springrestapi.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springrestapi.entity.Book;
import com.springrestapi.repo.BookRepo;
import com.springrestapi.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepo repo;

	@Override
	public List<Book> findAll() {
		return repo.findAll();
	}


	@Override
	public Optional<Book> findById(long id) {

		return repo.findById(id);
	}

	@Override
	public Book saveBook(Book s) {
		
		Book newBook = new Book();
		newBook.setBookName(s.getBookName());
		
		return repo.save(newBook);
	} 

	@Override
	public Book updateBook(Book book, long id) throws Exception {

		Book bookUpdate = repo.findById(id).orElseThrow(() -> new Exception("Book Not Found"));
		bookUpdate.setBookName(book.getBookName());

		return repo.save(bookUpdate);
	}

	@Override
	public void deleteById(long id) {
		repo.deleteById(id);
	}

}
