package com.sa45team7.stockist.service;

import java.util.Collection;
import java.util.LinkedHashMap;


import com.sa45team7.stockist.model.Product;
import com.sa45team7.stockist.model.Supplier;

public interface ReorderService {

	LinkedHashMap<Product, Integer> getReorderProductMap();
	
	LinkedHashMap<Product, Integer> getReoderProductMapBySupplier(int id);

	double getReorderSumPrice(LinkedHashMap<Product, Integer> map);

	Collection<Product> getReorderProductList();

	Collection<Product> getReorderProductListBySupplier(int id);

	Collection<Supplier> getSuppliersWithProducts();


	

}