package com.sa45team7.stockist.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sa45team7.stockist.model.User;

public interface UserService extends UserDetailsService {

	User authenticate(String uname, String pwd);
	
	ArrayList<User> findAllUsers();

}
