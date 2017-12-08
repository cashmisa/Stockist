package com.sa45team7.stockist.service;

import java.util.ArrayList;
import com.sa45team7.stockist.model.Product;
import com.sa45team7.stockist.model.ProductSearchDTO;

public interface ProductService {

	ArrayList<Product> getProductList();

	Product findProduct(Integer id);

	ArrayList<Product> findProductByName(String name);

	ArrayList<Product> findProductBySupplierId(Integer supplierId);

	ArrayList<Product> findProductByBrand(String brand);

	Product createProduct(Product product);

	void deleteProduct(Product product);

	Product updateProduct(Product product);
	
	ArrayList<Product> findProductByCriteria(ProductSearchDTO productSearchDTO);

}