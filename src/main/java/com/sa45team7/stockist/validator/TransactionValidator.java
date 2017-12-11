package com.sa45team7.stockist.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sa45team7.stockist.model.Transaction;
@Component
public class TransactionValidator implements Validator{
	
	
	@Override
	public boolean supports(Class<?> arg0) {
		
		 return Transaction.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) 
	{
		Transaction transaction = (Transaction) arg0;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "qty", "error.product.qty.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "transactionType", "error.transaction.transactionType.empty");
		
		  if (transaction.getQty() <= 0) 
		  {
			 arg1.rejectValue("qty", "error.product.qty.lessthan1");
		  }
	
		
		
		System.out.println(transaction.toString());			
	}
}
