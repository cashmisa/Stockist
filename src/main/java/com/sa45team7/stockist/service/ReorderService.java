package com.sa45team7.stockist.service;

import java.util.LinkedHashMap;

import org.springframework.transaction.annotation.Transactional;

import com.sa45team7.stockist.model.Product;

public interface ReorderService {

	LinkedHashMap<Product, Integer> getReorderProductList();

	LinkedHashMap<Product, Integer> getReoderProductListBySupplier(int id);

	double getReorderSumPrice(LinkedHashMap<Product, Integer> map);

}