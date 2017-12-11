package com.sa45team7.stockist.service;

import java.util.Collection;
import java.util.LinkedHashMap;

import org.springframework.transaction.annotation.Transactional;

import com.sa45team7.stockist.model.Product;
import com.sa45team7.stockist.model.ReportDTO;
import com.sa45team7.stockist.model.Supplier;

public interface ReorderService {

	// jasper datasource DTO
	Collection<ReportDTO> getReorderReportList();

	// jasper datasource DTO
	Collection<ReportDTO> getReorderReportListBySupplier(int id);

	// jasper helper
	Collection<Product> getReorderProductList();

	// jasper helper
	Collection<Product> getReorderProductListBySupplier(int id);

	// jasper helper method
	Collection<ReportDTO> getReportDTOList(Collection<Product> pList);

	// jasper helper method
	ReportDTO getReportDTO(Product p);

	// jsp page: get suppliers who have products
	Collection<Supplier> getSuppliersWithProducts();

	// jsp page
	LinkedHashMap<Product, Integer> getReorderProductMap();

	// jsp page
	LinkedHashMap<Product, Integer> getReoderProductMapBySupplier(int id);

	// jsp page
	double getReorderSumPrice(LinkedHashMap<Product, Integer> map);

}