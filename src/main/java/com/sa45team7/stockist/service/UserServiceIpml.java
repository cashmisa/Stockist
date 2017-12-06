package com.sa45team7.stockist.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa45team7.stockist.model.User;
import com.sa45team7.stockist.repository.UserRepository;



@Service
public class UserServiceIpml {

	@Resource
	private UserRepository userRepository;
	
	@Transactional
	public User authenticate(String uname, String pwd) {
		User u = userRepository.findUserByNamePwd(uname, pwd);
		return u;
	}
}
