package com.sa45team7.stockist.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sa45team7.stockist.model.Product;
import com.sa45team7.stockist.model.Transaction;
import com.sa45team7.stockist.service.ProductService;
import com.sa45team7.stockist.service.TransactionService;

@Controller
@RequestMapping("/viewproduct")
public class ViewProductController {
	//view one product and its transactions
	//MENG GUAN
	@Autowired
	ProductService pService;
	
	@Autowired
	TransactionService tService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewProductPage(@PathVariable String id) {
		Integer idi = Integer.parseInt(id); 
		ModelAndView mav = new ModelAndView("viewProductTransaction");
		Product product = pService.findProduct(idi);
		ArrayList<Transaction> transactions = tService.findTransactionByPartNo(idi);
		mav.addObject("product", product);
		mav.addObject("transactionList", transactions);
		return mav;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ModelAndView viewProduct(@PathVariable String id, @RequestParam("startDate") String startDate, @RequestParam("endDate")String endDate) throws ParseException {
		Integer idi = Integer.parseInt(id); 
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYY");
		Date endDateD;
		Date startDateD;
		try {
			startDateD = df.parse(startDate);
			endDateD = df.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("We need validator here");
			throw e;
		}				
		ModelAndView mav = new ModelAndView("viewProductTransaction");
		Product product = pService.findProduct(idi);
		ArrayList<Transaction> transactions = tService.findTransactionByPartNumberAndDate(idi, startDateD, endDateD);
		mav.addObject("product", product);
		mav.addObject("transactionList", transactions);
		return mav;
	}

	
	
	
}
