package com.sa45team7.stockist;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sa45team7.stockist.model.ProductDTO;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDTOTest {

	private static Validator validator;

	@BeforeClass
	public static void setUpValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void partNumberIsLessThanZero() {
		ProductDTO productDTO = new ProductDTO(-1, "part one", "test brand", 101, 1, 2, 2, 2.2, "b1");

		Set<ConstraintViolation<ProductDTO>> constraintViolations = validator.validate(productDTO);

		assertEquals(1, constraintViolations.size());
		assertEquals("must be greater than or equal to 0", constraintViolations.iterator().next().getMessage());
	}
}
