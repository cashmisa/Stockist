package com.sa45team7.stockist.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import com.sa45team7.stockist.model.Product;

public interface ProductService {

	ArrayList<Product> getProductList();

	Product findProduct(Integer id);

	ArrayList<Product> findProductByName(String name);

	ArrayList<Product> findProductBySupplierId(Integer supplierId);

	ArrayList<Product> findProductByBrand(String brand);

	Product createProduct(Product product);

	void deleteStudent(Product product);

	Product updateProduct(Product product);

}