package com.JavaGuides.LibraryManagement.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JavaGuides.LibraryManagement.entities.Book;
import com.JavaGuides.LibraryManagement.service.BookService;

@RestController
@RequestMapping("api/books")
public class BookController {
	
	private BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping
	public List<Book> getAllBooks(){
		return bookService.findAll();
	}
	
	@GetMapping("/{id}")
	public Book getBook(@PathVariable Long id) {
		return bookService.findById(id);
	}
	
	@PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

	@PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        // Additional logic to ensure you're updating the correct book
        return bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }
    
    @PostMapping("/{bookId}/borrow/{userId}")
    public ResponseEntity<Book> borrowBook(@PathVariable Long bookId, @PathVariable Long userId) {
        Book borrowedBook = bookService.borrowBook(bookId, userId);
        if (borrowedBook != null) {
            return ResponseEntity.ok(borrowedBook);
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }

    @PostMapping("/{bookId}/return")
    public ResponseEntity<Book> returnBook(@PathVariable Long bookId) {
        Book returnedBook = bookService.returnBook(bookId);
        if (returnedBook != null) {
            return ResponseEntity.ok(returnedBook);
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }
}
