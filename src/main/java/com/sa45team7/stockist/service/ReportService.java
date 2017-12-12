package com.sa45team7.stockist.service;

import java.util.Collection;
import java.util.Map;

import com.sa45team7.stockist.model.Product;
import com.sa45team7.stockist.model.ReportDTO;
import com.sa45team7.stockist.model.Supplier;

public interface ReportService {

	/*
	 * jsp: get suppliers who have products
	 */
	Collection<Supplier> findSuppliersWithProducts();

	/*
	 * jsp: get map of (product) & (its qty to reorder)
	 */
	Map<Product, Integer> findReorderQtyMap();

	/*
	 * jsp: get map of (product) & (its qty to reorder) for a given supplier
	 */
	Map<Product, Integer> findReoderQtyMapBySupplier(int id);

	/*
	 * jsp: calculate total cost for given products' reorders
	 */
	double getReorderSumPrice(Map<Product, Integer> map);

	/* 
	 * jasper: get ReportDTO list based on all products
	 */
	Collection<ReportDTO> findReorderDTOList();

	/* 
	 * jasper: get ReportDTO list based on all products for a given supplier 
	 */
	Collection<ReportDTO> findReorderDTOListBySupplier(int id);


}