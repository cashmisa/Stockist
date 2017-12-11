package com.sa45team7.stockist.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sa45team7.stockist.model.Supplier;

@Component
public class SupplierValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Supplier.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		Supplier supplier = (Supplier) arg0;

		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "supplierName", "error.supplier.supplierName.empty");

		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "contactName", "error.supplier.contactName.empty");

		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "phoneNumber", "error.supplier.phoneNo.empty");

		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "email", "error.supplier.email.empty");

		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "website", "error.supplier.website.empty");

		Pattern Emailpattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		if (!(Emailpattern.matcher(supplier.getEmail()).matches()) && (!supplier.getEmail().isEmpty())) {
			arg1.rejectValue("email", "error.supplier.email.invalid");
		}
		/*
		 * Pattern Phonepattern = Pattern.compile("/^[0-9]{8}$/",
		 * Pattern.CASE_INSENSITIVE); if
		 * (!(Phonepattern.matcher(supplier.getPhoneNumber()).matches()) &&
		 * (!supplier.getPhoneNumber().isEmpty())) { arg1.rejectValue("phoneNumber",
		 * "error.supplier.phoneno.invalid"); }
		 */
		Pattern phonePattern = Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE);
		String s = supplier.getPhoneNumber();

		if (!s.isEmpty()) {
			if ((s.length() != 8) || (phonePattern.matcher(s).matches())) {
				arg1.rejectValue("phoneNumber", "error.supplier.phoneno.invalid");
			}
		}

		Pattern Websitepattern = Pattern.compile(
				"(www\\.)+[a-zA-Z0-9\\.\\-\\_]+(\\.[a-zA-Z]{2,3})+(\\/[a-zA-Z0-9\\_\\-\\s\\.\\/\\?\\%\\#\\&\\=]*)?$",
				Pattern.CASE_INSENSITIVE);
		if (!Websitepattern.matcher(supplier.getWebsite()).matches() && (!supplier.getWebsite().isEmpty())) {
			arg1.rejectValue("website", "error.supplier.website.invalid");
		}

		System.out.println(supplier.toString());
	}

}
