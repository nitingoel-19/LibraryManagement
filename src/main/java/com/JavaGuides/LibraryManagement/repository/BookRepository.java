package com.JavaGuides.LibraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JavaGuides.LibraryManagement.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
