package com.springrestapi.service;

import java.util.List;
import java.util.Optional;
import com.springrestapi.entity.Book;

public interface BookService {

	public List<Book> findAll();

	public Optional<Book> findById(long id);

	public Book saveBook(Book book);

	public Book updateBook(Book book, long id) throws Exception;

	public void deleteById(long id);


}
