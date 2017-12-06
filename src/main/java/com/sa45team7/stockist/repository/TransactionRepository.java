package com.sa45team7.stockist.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sa45team7.stockist.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer > {
	@Query("SELECT t FROM Transaction t where t.transactionId = :id")
	Transaction findTransactionByTransactionId(@Param("id") Integer id);
	
	@Query("SELECT t FROM Transaction t where t.product.partNumber = :partNumber")
	ArrayList<Transaction> findTransactionByPartNumber(@Param("partNumber") int partNumber);
	
	@Query("SELECT t FROM Transaction t where t.transactionType = :transactionType")
	ArrayList<Transaction> findTransactionByTransactionType(@Param("transactionType") String transactionType);
	
	@Query("SELECT t FROM Transaction t where t.date BETWEEN :startDate AND :endDate")
	ArrayList<Transaction> findTransactionByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
}
