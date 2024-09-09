package com.JavaGuides.LibraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JavaGuides.LibraryManagement.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
