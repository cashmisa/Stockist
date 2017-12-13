package com.sa45team7.stockist.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sa45team7.stockist.model.User;

public interface UserService extends UserDetailsService {

	User authenticate(String uname, String pwd);

	ArrayList<User> findAllUsers();

	User findUser(String userName);

	User createUser(User user);

	User changeUser(User user);

	void removeUser(User user);

	ArrayList<String> findAllRoles();

	void resetUser(User user);

	void updatePassword(User user);

}
