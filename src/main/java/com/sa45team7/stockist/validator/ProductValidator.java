package com.sa45team7.stockist.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sa45team7.stockist.model.Product;

@Component
public class ProductValidator implements Validator {
	
	@Override
		public boolean supports(Class<?> arg0) {
			// TODO Auto-generated method stub
			 return Product.class.isAssignableFrom(arg0);
		}

		@Override
		public void validate(Object arg0, Errors arg1) 
		{
			// TODO Auto-generated method stub
			Product product = (Product) arg0;
			
			ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "partName", "error.product.partName.empty");
			
			ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "brand", "error.product.brand.empty");
			
			ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "supplierId", "error.product.supplierId.empty");
			
			ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "qty", "error.product.qty.empty");
			
			ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "minOrderQty", "error.product.minOrderQty.empty");
			
            ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "reOrderQty", "error.product.reOrderQty.empty");
			
			ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "price", "error.product.price.empty");
			
			ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "shelfLocation", "error.product.shelfLocation.empty");

			System.out.println(product.toString());
		}

}

