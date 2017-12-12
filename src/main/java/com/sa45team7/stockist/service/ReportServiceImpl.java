package com.sa45team7.stockist.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa45team7.stockist.model.Product;
import com.sa45team7.stockist.model.ReportDTO;
import com.sa45team7.stockist.model.Supplier;
import com.sa45team7.stockist.repository.ProductRepository;
import com.sa45team7.stockist.repository.SupplierRepository;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ProductService pService;

	@Resource
	private ProductRepository pRepo;

	@Resource
	private SupplierRepository sRepo;

	/* 
	 * jsp: get all suppliers who have products 
	 */
	@Override
	@Transactional
	public Collection<Supplier> findSuppliersWithProducts() {
		return sRepo.findSuppliersByIdList(pRepo.findSupplierIdsWithProducts());
	}

	/* 
	 * jsp: get map of (product) & (its qty to reorder) 
	 */
	@Override
	@Transactional
	public Map<Product, Integer> findReorderQtyMap() {
		return getReorderQtyMap(pService.findProductListSorted());
	}

	/*
	 * jsp: get map of (product) & (its qty to reorder) for a given supplier
	 */
	@Override
	@Transactional
	public Map<Product, Integer> findReoderQtyMapBySupplier(int id) {
		return getReorderQtyMap(pService.findProductBySupplierId(id));
	}

	/*
	 * jsp: calculate total cost for given products' reorder
	 */
	@Override
	public double getReorderSumPrice(Map<Product, Integer> map) {
		double sumPrice = 0;
		for (Product p : map.keySet()) {
			sumPrice += p.getPrice() * map.get(p);
		}
		return sumPrice;
	}

	/*
	 * helper method to get map of (product) & (its qty to reorder) 
	 */
	private Map<Product, Integer> getReorderQtyMap(List<Product> pList) {
		LinkedHashMap<Product, Integer> rMap = new LinkedHashMap<>();
		for (Product p : pList) {
			rMap.put(p, getQtyToReorder(p.getQty(), p.getReOrderQty(), p.getMinOrderQty()));
		}
		return rMap;
	}

	/* 
	 * jasper: get ReportDTO list based on all products
	 */
	@Override
	@Transactional
	public Collection<ReportDTO> findReorderDTOList() {
		return convertToReportDTOList(pService.findProductListSorted());
	}

	/* 
	 * jasper: get ReportDTO list based on all products for a given supplier 
	 */
	@Override
	@Transactional
	public Collection<ReportDTO> findReorderDTOListBySupplier(int id) {
		return convertToReportDTOList(pService.findProductBySupplierId(id));
	}

	
	/* 
	 * jasper helper method 
	 */
	private Collection<ReportDTO> convertToReportDTOList(Collection<Product> pList) {
		Collection<ReportDTO> dtoList = new ArrayList<>();
		for (Product p : pList) {
			dtoList.add(convertToReportDTO(p));
		}
		return dtoList;
	}

	/*
	 * jasper helper method
	 */
	private ReportDTO convertToReportDTO(Product p) {
		ReportDTO dto = new ReportDTO();
		BeanUtils.copyProperties(p, dto);
		dto.setSupplierId(p.getSupplier().getSupplierId());
		dto.setSupplierName(p.getSupplier().getSupplierName());
		dto.setQtyToReorder(getQtyToReorder(p.getQty(), p.getReOrderQty(), p.getMinOrderQty()));
		return dto;
	}
	
	/*
	 * business logic for qty to reorder
	 */
	private int getQtyToReorder(int qty, int reorderQty, int minOrderQty) {
		return qty < reorderQty? (reorderQty - qty < minOrderQty? minOrderQty:reorderQty - qty) : 0;
	}

}
