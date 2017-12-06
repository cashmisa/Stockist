package com.sa45team7.stockist.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sa45team7.stockist.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer > {
	@Query("SELECT p FROM Product p where p.partNumber = :id")
	Product findProductByPartNumber(@Param("id") Integer id);
	
	@Query("SELECT p FROM Product p where p.partName = :name")
	ArrayList<Product> findProductByName(@Param("name") String name);
	
	@Query("SELECT p FROM Product p where p.supplier.supplierId = :supplierId")
	ArrayList<Product> findProductBySupplierId(@Param("supplierId") Integer supplierId);
	
	@Query("SELECT p FROM Product p where p.brand = :brand")
	ArrayList<Product> findProductByBrand(@Param("brand") String brand);
		
}
