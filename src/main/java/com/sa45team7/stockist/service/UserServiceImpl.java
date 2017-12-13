package com.sa45team7.stockist.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa45team7.stockist.model.User;
import com.sa45team7.stockist.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;

	@Override
	@Transactional
	public User authenticate(String uname, String pwd) {
		User u = userRepository.findUserByNamePwd(uname, pwd);
		return u;
	}

	@Transactional
	public ArrayList<User> findAllUsers() {
		ArrayList<User> ul = (ArrayList<User>) userRepository.findAll();
		return ul;
	}

	@Override
	@Transactional
	public User findUser(String userId) {
		return userRepository.findOne(userId);

	}

	@Override
	@Transactional
	public User createUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	@Override
	@Transactional
	public User changeUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	@Override
	@Transactional
	public void removeUser(User user) {
		userRepository.delete(user);
	}
	
	@Override
	@Transactional
	public ArrayList<String> findAllRoles() {
		return userRepository.findRoles();
	}	
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findUserByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("No user found with username: " + username);
		} else {
			return user;
		}
	}

	@Override
	@Transactional
	public void resetUser(User user) {
		user.setPassword("123456");
		userRepository.saveAndFlush(user);
	}

	@Override
	@Transactional
	public void updatePassword(User user) {
		userRepository.saveAndFlush(user);
	}

}
