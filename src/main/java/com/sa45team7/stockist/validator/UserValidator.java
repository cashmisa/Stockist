package com.sa45team7.stockist.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sa45team7.stockist.model.User;

@Component
public class UserValidator implements Validator {
	
	private static final int MINIMUM_PASSWORD_LENGTH = 6;
	
	@Override
		public boolean supports(Class<?> arg0) {
			
			 return User.class.isAssignableFrom(arg0);
		}

		@Override
		public void validate(Object arg0, Errors arg1) 
		{
			User user = (User) arg0;
			
			ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "password", "error.user.password.empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "userName", "error.user.username.empty");
			
			  if (user.getPassword().trim().length() < MINIMUM_PASSWORD_LENGTH) 
			  {
				 arg1.rejectValue("password", "error.user.password.tooshort");
			  }
		
			
			
			System.out.println(user.toString());			
		}

	}


