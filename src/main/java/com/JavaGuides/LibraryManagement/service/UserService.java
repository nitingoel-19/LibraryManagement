package com.JavaGuides.LibraryManagement.service;

import java.util.List;

import com.JavaGuides.LibraryManagement.entities.User;

public interface UserService {
	
	public List<User> findAll();
	
	public User saveUser(User user);

}
