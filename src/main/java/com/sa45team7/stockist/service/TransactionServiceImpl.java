package com.sa45team7.stockist.service;

import java.util.ArrayList;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa45team7.stockist.model.Transaction;
import com.sa45team7.stockist.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Resource
	private TransactionRepository transactionRepository;

	public ArrayList<Transaction> findAllTransaction() {
		ArrayList<Transaction> l = (ArrayList<Transaction>) transactionRepository.findAll();
		return l;
	}

	@Transactional
	public Transaction findTransactionById(Integer tranId) {
		return transactionRepository.findTransactionByTransactionId(tranId);

	}

	@Transactional
	public ArrayList<Transaction> findTransactionByPartNo(Integer partNo) {
		return transactionRepository.findTransactionByPartNumber(partNo);

	}

	@Transactional
	public ArrayList<Transaction> findTransactionByDate(Date startDate, Date endDate) {
		return transactionRepository.findTransactionByDate(startDate, endDate);

	}
	@Transactional
	public Transaction createTransaction(Transaction transaction)
	{
		
			return transactionRepository.saveAndFlush(transaction);
		
	}
	
	@Transactional
	public ArrayList<Transaction> findTransactionByPartNumberAndDate(int partNumber, Date startDate, Date endDate){
		return transactionRepository.findTransactionByPartNumberAndDate(partNumber, startDate, endDate);
	}
	
	@Transactional
	public ArrayList<String> findAllTransactionType(){
		
			ArrayList<String> listOfTypes = new ArrayList<String>();
			listOfTypes.add("used");
			listOfTypes.add("received");
			listOfTypes.add("returned");
			return listOfTypes;
	}
	
	public long findNoOfTransaction(Integer partNumber) {
		return transactionRepository.findNoOfTransaction(partNumber);
	}

}
