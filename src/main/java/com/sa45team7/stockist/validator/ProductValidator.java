package com.sa45team7.stockist.validator;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sa45team7.stockist.model.ProductDTO;

@Component
public class ProductValidator implements Validator {

	@Autowired
	private MessageSource messageSource;

	private Locale locale = LocaleContextHolder.getLocale();

	@Override
	public boolean supports(Class<?> arg0) {
		return ProductDTO.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProductDTO productDTO = (ProductDTO) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "partName", "error.empty",
				new String[] { messageSource.getMessage("fieldLabel.partName", null, locale) });

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "brand", "error.empty",
				new String[] { messageSource.getMessage("fieldLabel.partBrand", null, locale) });

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shelfLocation", "error.empty",
				new String[] { messageSource.getMessage("fieldLabel.partLocation", null, locale) });
		
		System.out.println(productDTO.toString());
	}

}
