package com.JavaGuides.LibraryManagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String author;
    private boolean borrowed;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User borrowedBy;

	// we don't need setter method for @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isBorrowed() {
		return borrowed;
	}

	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}

	public User getBorrowedBy() {
		return borrowedBy;
	}

	public void setBorrowedBy(User borrowedBy) {
		this.borrowedBy = borrowedBy;
	}

}
