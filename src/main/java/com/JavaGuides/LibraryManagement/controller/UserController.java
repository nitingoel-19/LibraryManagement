package com.JavaGuides.LibraryManagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JavaGuides.LibraryManagement.entities.User;
import com.JavaGuides.LibraryManagement.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> getAllUsers(){
		return userService.findAll();
	}
	
	@PostMapping
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
