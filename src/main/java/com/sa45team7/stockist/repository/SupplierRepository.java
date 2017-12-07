package com.sa45team7.stockist.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sa45team7.stockist.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer > {
	
	@Query("SELECT s FROM Supplier s where s.supplierName = :name")
	Supplier findSupplierByName(@Param("name") String name);
	
	@Query("SELECT s FROM Supplier s where s.contactName = :contactName")
	Supplier findSupplierByContactName(@Param("contactName") String contactName);
	
	@Query("SELECT s FROM Supplier s where s.phoneNumber = :phoneNumber")
	Supplier findSupplierByPhoneNumber(@Param("phoneNumber") String phoneNumber);
	
	@Query("SELECT s FROM Supplier s where s.email = :email")
	Supplier findSupplierByEmail(@Param("email") String email);
	
	@Query("SELECT s FROM Supplier s where s.website = :website")
	Supplier findSupplierByWebsite(@Param("website") String website);
	
	@Query("SELECT DISTINCT s.supplierId FROM Supplier s")
	ArrayList<Integer>findAllSupplierIDs();

	
}

