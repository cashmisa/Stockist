package com.sa45team7.stockist.service;

import java.util.ArrayList;

import com.sa45team7.stockist.model.User;



public interface UserService {

	User authenticate(String uname, String pwd);

	ArrayList<User> findAllUsers();

	User findUser(String userId);

	User createUser(User user);

	User changeUser(User user);

	void removeUser(User user);

	}
