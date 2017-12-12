package com.sa45team7.stockist.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sa45team7.stockist.model.User;


public interface UserRepository extends JpaRepository<User, String>{
	
	@Query("SELECT u FROM User u WHERE u.userName=:un AND u.password=:pwd")
	User findUserByNamePwd(@Param("un") String username, @Param("pwd") String password);
	
	@Query("SELECT u FROM User u WHERE u.userName = :userName")
	User findUserByUserName(@Param("userName") String userName);
	
	@Query("SELECT u FROM User u WHERE u.role = :role")
	ArrayList<User> findUserByRole(@Param("role") String role);
	
	@Query("SELECT DISTINCT u.role FROM User u")
	ArrayList<String> findRoles();
	
}
