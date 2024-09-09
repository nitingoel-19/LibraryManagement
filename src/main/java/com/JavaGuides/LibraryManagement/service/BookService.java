package com.JavaGuides.LibraryManagement.service;

import java.util.List;

import com.JavaGuides.LibraryManagement.entities.Book;

public interface BookService {
	
	public List<Book> findAll();
	public Book findById(Long id);
	public Book saveBook(Book book);
	public void deleteById(Long id);
	public Book borrowBook(Long bookId,Long userId);
	public Book returnBook(Long bookId);

}
