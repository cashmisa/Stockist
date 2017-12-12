package com.sa45team7.stockist.service;

import java.util.ArrayList;
import java.util.Date;

import com.sa45team7.stockist.model.Transaction;


public interface TransactionService
{
	
	ArrayList<Transaction> findAllTransaction();
	
	Transaction findTransactionById(Integer tranId);
	
	ArrayList<Transaction> findTransactionByPartNo(Integer partNo);
	
	ArrayList<Transaction> findTransactionByDate(Date startDate,Date endDate);

	Transaction createTransaction(Transaction t);
	
	ArrayList<Transaction> findTransactionByPartNumberAndDate(int partNumber, Date startDate, Date endDate);
	
	ArrayList<String> findAllTransactionType();
	
	long findNoOfTransaction(Integer partNumber);
	
}