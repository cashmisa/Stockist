package com.sa45team7.stockist.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sa45team7.stockist.model.User;

@Component
public class UserValidator implements Validator {
	
	@Override
		public boolean supports(Class<?> arg0) {
			
			 return User.class.isAssignableFrom(arg0);
		}

		@Override
		public void validate(Object arg0, Errors arg1) 
		{
			User user = (User) arg0;
			
			ValidationUtils.rejectIfEmpty(arg1, "userName", "error.user.userName.empty");
			
			System.out.println(user.toString());			
		}

	}


