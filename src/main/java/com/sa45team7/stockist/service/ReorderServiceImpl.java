package com.sa45team7.stockist.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa45team7.stockist.model.Product;

@Service
public class ReorderServiceImpl implements ReorderService {
	
	@Autowired
	private ProductService pService;

	/*
	 * If (reoderQty - qty < minQty) {orderAmount=minQty} else {orderAmount=reorderQty-qty}
	 * return a Map<Product, orderAmount> sorted by partNumber
	 */
	
	//jasper datasource
	@Override
	@Transactional
	public Collection<Product> getReorderProductList() {
		return pService.getProductListSorted();
	}
	
	//jasper datasource
	@Override
	@Transactional
	public Collection<Product> getReorderProductListBySupplier(int id){
		return pService.findProductBySupplierId(id);
	}
	
	//jsp page
	@Override
	@Transactional
	public LinkedHashMap<Product, Integer> getReorderProductMap() {
		return getReorderMap(pService.getProductListSorted());
	}
	
	//jsp page
	@Override
	@Transactional
	public LinkedHashMap<Product, Integer> getReoderProductMapBySupplier(int id){
		return getReorderMap(pService.findProductBySupplierId(id));
	}
	
	//jsp page
	@Override
	@Transactional
	public double getReorderSumPrice(LinkedHashMap<Product, Integer> map) {
		double sumPrice = 0;
		for (Product p : map.keySet()) {
			sumPrice += p.getPrice()*map.get(p);
		}
		return sumPrice;
	}
	
	/*
	 * Helper method
	 * passing a list of (sorted) products, return products and its respective orderAmount
	 * if it is 0, add it too
	 */
	private LinkedHashMap<Product, Integer> getReorderMap(ArrayList<Product> pList){
		LinkedHashMap<Product, Integer> rMap = new LinkedHashMap<>();
		for (Product p : pList) {
			if (p.getQty() < p.getReOrderQty()) {
				rMap.put(p, (p.getReOrderQty() - p.getQty()) < p.getMinOrderQty() ? p.getMinOrderQty()
						: (p.getReOrderQty() - p.getQty()));
			}
			else {
				rMap.put(p, 0);
			}
		}
		return rMap;
	}
	
	
}
