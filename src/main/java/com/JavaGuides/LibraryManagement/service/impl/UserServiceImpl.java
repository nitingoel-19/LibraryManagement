package com.JavaGuides.LibraryManagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.JavaGuides.LibraryManagement.entities.User;
import com.JavaGuides.LibraryManagement.repository.UserRepository;
import com.JavaGuides.LibraryManagement.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

}
