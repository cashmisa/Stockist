package com.sa45team7.stockist.service;

import java.util.ArrayList;
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
	 * 1. ContainpartNumber, price, qty, reorderQty, minQty, orderAmount and price 
	 * 2. If (reoderQty - qty < minQty) {orderAmount=minQty} else {orderAmount=reorderQty-qty}
	 * 3. return a Map<Product, orderAmount> sorted by partNumber
	 * 
	 */
	
	/* (non-Javadoc)
	 * @see com.sa45team7.stockist.service.ReoderService#getReorderProductList()
	 */
	@Override
	@Transactional
	public LinkedHashMap<Product, Integer> getReorderProductList() {
		return getReorderList(pService.getProductListSorted());
	}
	
	/* (non-Javadoc)
	 * @see com.sa45team7.stockist.service.ReoderService#getReoderProductListBySupplier(int)
	 */
	@Override
	@Transactional
	public LinkedHashMap<Product, Integer> getReoderProductListBySupplier(int id){
		return getReorderList(pService.findProductBySupplierId(id));
	}
	
	/* (non-Javadoc)
	 * @see com.sa45team7.stockist.service.ReoderService#getReorderSumPrice(java.util.LinkedHashMap)
	 */
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
	private LinkedHashMap<Product, Integer> getReorderList(ArrayList<Product> pList){
		LinkedHashMap<Product, Integer> rList = new LinkedHashMap<>();
		for (Product p : pList) {
			if (p.getQty() < p.getReOrderQty()) {
				rList.put(p, (p.getReOrderQty() - p.getQty()) < p.getMinOrderQty() ? p.getMinOrderQty()
						: (p.getReOrderQty() - p.getQty()));
			}
			else {
				rList.put(p, 0);
			}
		}
		return rList;
	}
	
	
}
