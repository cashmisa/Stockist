package com.sa45team7.stockist.service;

import java.util.ArrayList;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa45team7.stockist.model.Transaction;
import com.sa45team7.stockist.repository.TransactionRepository;


@Service
public class TransactionServicempl implements TransactionService {
	@Resource
	private TransactionRepository tansactionRepository;

	public ArrayList<Transaction> findAllTransaction() {
		ArrayList<Transaction> l = (ArrayList<Transaction>) tansactionRepository.findAll();
		return l;
	}

	@Transactional
	public Transaction findTransactionById(Integer tranId) {
		return tansactionRepository.findTransactionByTransactionId(tranId);

	}

	@Transactional
	public ArrayList<Transaction> findTransactionByPartNo(Integer partNo) {
		return tansactionRepository.findTransactionByPartNumber(partNo);

	}

	@Transactional
	public ArrayList<Transaction> findTransactionByDate(Date startDate, Date endDate) {
		return tansactionRepository.findTransactionByDate(startDate, endDate);

	}
	@Transactional
	public Transaction createTransaction(Transaction transaction)
	{
		
			return tansactionRepository.saveAndFlush(transaction);
		
	}

}
