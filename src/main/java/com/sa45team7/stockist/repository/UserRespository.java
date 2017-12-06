package com.sa45team7.stockist.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRespository extends JpaRepository<User, String > {
	@Query("SELECT u FROM User u where u.userName = :userName")
	User findUserByUserName(@Param("userName") String userName);
	
	@Query("SELECT u FROM User u where u.role = :role")
	ArrayList<User> findUserByRole(@Param("role") String role);		
} 
