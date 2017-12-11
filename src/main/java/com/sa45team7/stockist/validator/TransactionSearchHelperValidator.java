package com.sa45team7.stockist.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sa45team7.stockist.model.StartEndDate;

@Component
public class TransactionSearchHelperValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return StartEndDate.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		StartEndDate transactionSearchHelper = (StartEndDate) arg0;
		if ((transactionSearchHelper.getStartDate() != null && transactionSearchHelper.getEndDate() != null)
				&& (transactionSearchHelper.getStartDate()).after(transactionSearchHelper.getEndDate())) {
			arg1.reject("endDate");
			arg1.rejectValue("endDate", "error.transactionSearch.StartBeforeEnd");

		}
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "startDate", "error.transactionSearch.startDate");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "endDate", "error.transactionSearch.endDate");
		
		/*A good date pattern validator, but this validator is unreachable because startdate and enddate is strongly typed, so type mismatch will be thrown 
		 * 
		 * Pattern datePattern = Pattern.compile("/(^(((0[1-9]|1[0-9]|2[0-8])[-](0[1-9]|1[012]))|((29|30|31)[-](0[13578]|1[02]))|((29|30)[-](0[4,6,9]|11)))[-](19|[2-9][0-9])\\\\d\\\\d$)|(^29[-]02[-](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)/");*/
		
		
	}
}
