package com.sa45team7.stockist.service;

import java.util.ArrayList;
import com.sa45team7.stockist.model.Product;
import com.sa45team7.stockist.model.ProductDTO;

public interface ProductService {

	ArrayList<Product> findProductList();

	Product findProduct(Integer id);

	ArrayList<Product> findProductByName(String name);

	ArrayList<Product> findProductBySupplierId(Integer supplierId);

	ArrayList<Product> findProductByBrand(String brand);

	Product createProduct(Product product);
	
	Product createProduct(ProductDTO productDTO);

	void deleteProduct(Product product);

	Product updateProduct(Product product);
	
	Product updateProduct(ProductDTO productDTO);
	
	ArrayList<Integer> findAllPartNumber();

	ArrayList<Product> findProductListSorted();
	
	ArrayList<Product> findProductByExample(ProductDTO productDTO);


	

}