package com.sa45team7.stockist.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sa45team7.stockist.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
	@Query("SELECT p FROM Product p where p.partNumber = :id")
	Product findProductByPartNumber(@Param("id") Integer id);
	
	
	@Query("SELECT p FROM Product p where p.partName = :name")
	ArrayList<Product> findProductByName(@Param("name") String name);
	
	
	@Query("SELECT p FROM Product p where p.supplier.supplierId = :supplierId")
	ArrayList<Product> findProductBySupplierId(@Param("supplierId") Integer supplierId);
	
	
	@Query("SELECT p FROM Product p where p.brand = :brand")
	ArrayList<Product> findProductByBrand(@Param("brand") String brand);
	
	//"select * from stockist.product where partNumber like \"%100%\";
	
	
	@Query(value = "SELECT * FROM Product WHERE partNumber like %:partNumber%", nativeQuery = true)
	ArrayList<Product> findByPartNumberContaining(@Param("partNumber") String partNumber);
	
	
	ArrayList<Product> findByBrandContaining(String brand);
	
	// TODO - remove unnecessary methods
	ArrayList<Product> findByMinOrderQty(int minOrderQty);
	ArrayList<Product> findByMinOrderQtyLessThanEqual(int minOrderQty);
	ArrayList<Product> findByMinOrderQtyGreaterThanEqual(int minOrderQty);
	ArrayList<Product> findByMinOrderQtyBetween(int min, int max);
	
	
	ArrayList<Product> findByPartNameContaining(String partName);
	
	
	ArrayList<Product> findByPrice(double price);
	ArrayList<Product> findByPriceLessThanEqual(double price);	
	ArrayList<Product> findByPriceGreaterThanEqual(double price);
	ArrayList<Product> findByPriceBetween(double min, double max);
	
	
	ArrayList<Product> findByQty(int qty);
	ArrayList<Product> findByQtyLessThanEqual(int qty);
	ArrayList<Product> findByQtyGreaterThanEqual(int qty);
	ArrayList<Product> findByQtyBetween(int min, int max);
	
	
	ArrayList<Product> findByReOrderQty(int reOrderQty);
	ArrayList<Product> findByReOrderQtyLessThanEqual(int reOrderQty);
	ArrayList<Product> findByReOrderQtyGreaterThanEqual(int reOrderQty);
	ArrayList<Product> findByReOrderQtyBetween(int min, int max);
	
	
	ArrayList<Product> findByShelfLocationContaining(String shelfLocation);
	
}
