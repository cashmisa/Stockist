package com.sa45team7.stockist.service;

import com.sa45team7.stockist.model.User;

public interface UserService {

	User authenticate(String uname, String pwd);

}
