package com.sa45team7.validator;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sa45team7.stockist.model.Supplier;
@Component
public class SupplierValidator implements Validator  {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		 return Supplier.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) 
	{
		// TODO Auto-generated method stub
		Supplier supplier = (Supplier) arg0;
		
		ValidationUtils.rejectIfEmpty(arg1, "supplierName", "error.supplier.supplierName.empty");
		
		
		ValidationUtils.rejectIfEmpty(arg1, "contactName", "error.supplier.contactName.empty");
		
		ValidationUtils.rejectIfEmpty(arg1, "phoneNumber", "error.supplier.phoneNo.empty");
		
		ValidationUtils.rejectIfEmpty(arg1, "email", "error.supplier.email.empty");
		
		ValidationUtils.rejectIfEmpty(arg1, "website", "error.supplier.website.empty");
		
		System.out.println(supplier.toString());
	}

}
