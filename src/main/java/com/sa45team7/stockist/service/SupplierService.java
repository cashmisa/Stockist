package com.sa45team7.stockist.service;

import java.util.ArrayList;

import com.sa45team7.stockist.model.Supplier;


public interface SupplierService {
	
	ArrayList<Supplier> findAllSuppliers();
	
	ArrayList<Integer> findAllSupplierIDs();
	
	void removeSupplier(Supplier supplier);
	
	Supplier findSupplier(Integer supplierId);
	
	ArrayList<Supplier> findSupplierByName(String supplierName);
	
	Supplier findSupplierByContactName(String contactName);
	
	Supplier findSupplierByPhoneNumber(String phoneNumber);
	
	Supplier findSupplierByEmail(String email);
	
	Supplier findSupplierByWebSite(String website);
	
	Supplier createSupplier(Supplier supplier);
	
	Supplier changeSupplier(Supplier supplier);
}
	
