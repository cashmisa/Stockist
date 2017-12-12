package com.sa45team7.stockist.validator;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sa45team7.stockist.model.Product;
import com.sa45team7.stockist.model.Transaction;
import com.sa45team7.stockist.service.ProductService;

@Component
public class TransactionValidator implements Validator {

	@Autowired
	ProductService productService;

	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Override
	public boolean supports(Class<?> arg0) {

		return Transaction.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Transaction transaction = (Transaction) target;

		Product product = productService.findProduct(transaction.getPartNumber());

		if (transaction.getQty() <= 0) {
			errors.rejectValue("qty", "error.product.qty.lessthan1");
		}

		if (product == null) {
			errors.rejectValue("partNumber", "error.product.productNotFound");
		} else {

			if (product.getQty() - transaction.getQty() < 0) {
				errors.rejectValue("qty", "error.product.inventoryShortage");
			}
		}

		System.out.println(transaction.toString());
	}
}
