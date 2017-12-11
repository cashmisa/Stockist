package com.sa45team7.stockist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NO_CONTENT, reason="No such User")
public class UserNotFound extends Exception
{

}