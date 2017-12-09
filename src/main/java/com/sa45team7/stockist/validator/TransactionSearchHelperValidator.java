package com.sa45team7.stockist.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sa45team7.stockist.helper.TransactionSearchHelper;

@Component
public class TransactionSearchHelperValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return TransactionSearchHelper.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		TransactionSearchHelper transactionSearchHelper = (TransactionSearchHelper) arg0;
		if ((transactionSearchHelper.getStartDate() != null && transactionSearchHelper.getEndDate() != null)
				&& (transactionSearchHelper.getStartDate()).after(transactionSearchHelper.getEndDate())) {
			arg1.reject("endDate", "End date should be later than start date.");
			arg1.rejectValue("endDate", "error.dates", "End date must be later from start date");

		}
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "startDate", "error.startDate", "Start Date is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "endDate", "error.endDate", "End Date is required.");
		
	}
}
