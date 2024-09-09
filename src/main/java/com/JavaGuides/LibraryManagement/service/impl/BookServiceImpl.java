package com.JavaGuides.LibraryManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JavaGuides.LibraryManagement.entities.Book;
import com.JavaGuides.LibraryManagement.entities.User;
import com.JavaGuides.LibraryManagement.repository.BookRepository;
import com.JavaGuides.LibraryManagement.repository.UserRepository;
import com.JavaGuides.LibraryManagement.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	private BookRepository bookRepository;
	
	@Autowired
	private UserRepository userRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book findById(Long id) {
		return bookRepository.findById(id).get();
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void deleteById(Long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public Book borrowBook(Long bookId, Long userId) {
		Book book = findById(bookId);
        User user = userRepository.findById(userId).orElse(null);

        if (book != null && !book.isBorrowed() && user != null) {
            book.setBorrowedBy(user);
            book.setBorrowed(true);
            return saveBook(book);
        }
        // Handle errors (e.g., book not found, book already borrowed, user not found)
        return null;
	}

	@Override
	public Book returnBook(Long bookId) {
		Book book = findById(bookId);
        if (book != null && book.isBorrowed()) {
            book.setBorrowedBy(null);
            book.setBorrowed(false);
            return saveBook(book);
        }
        // Handle errors (e.g., book not found, book not borrowed)
        return null;
	}

}
