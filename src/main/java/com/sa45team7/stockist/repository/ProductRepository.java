package com.sa45team7.stockist.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends JpaRepository<Product, Integer > {
	@Query("SELECT p FROM Product p where p.partNumber = :id")
	Product findProductById(@Param("id") String id);
	
	@Query("SELECT p FROM Product p where p.name = :name")
	ArrayList<Product> findProductByName(@Param("name") String name);
	
	@Query("SELECT p FROM Product p where p.supplierId = :supplierid")
	ArrayList<Product> findProductBySupplierId(@Param("supplierid") String supplierId);
	
	@Query("SELECT p FROM Product p where p.brand = :brand")
	ArrayList<Product> findProductByBrand(@Param("brand") String brand);
	

}
