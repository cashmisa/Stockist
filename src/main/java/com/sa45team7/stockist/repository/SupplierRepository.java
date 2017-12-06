package com.sa45team7.stockist.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SupplierRepository extends JpaRepository<Supplier, Integer > {
	@Query("SELECT s FROM Product s where s.supplierId = :id")
	Supplier findSupplierById(@Param("id") String id);
	
	@Query("SELECT s FROM Product s where s.name = :name")
	ArrayList<Supplier> findSupplierByName(@Param("name") String name);
}

