package com.sa45team7.stockist.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sa45team7.stockist.model.Product;
import com.sa45team7.stockist.model.Transaction;
import com.sa45team7.stockist.model.StartEndDate;
import com.sa45team7.stockist.service.ProductService;
import com.sa45team7.stockist.service.TransactionService;
import com.sa45team7.stockist.validator.TransactionSearchHelperValidator;


@Controller
@RequestMapping("/viewproduct")
public class ViewProductController {
	//view one product and its transactions
	//MENG GUAN
	@Autowired
	ProductService pService;
	
	@Autowired
	TransactionService tService;
	
	@Autowired
	private TransactionSearchHelperValidator tValidator;
	
	@InitBinder("transactionSearchHelper")
	private void initSupplierBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.setValidator(tValidator);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewProductPage(@ModelAttribute("transactionSearchHelper") StartEndDate transactionSearchHelper,  @PathVariable String id) {
		Integer idi = Integer.parseInt(id); 
		ModelAndView mav = new ModelAndView("viewProductTransaction", "transactionSearchHelper", new StartEndDate());
		Product product = pService.findProduct(idi);
		ArrayList<Transaction> transactions = tService.findTransactionByPartNo(idi);
		Long noOfTransactions = tService.findNoOfTransaction(idi);
		mav.addObject("product", product);
		mav.addObject("transactionList", transactions);
		mav.addObject("transactionL", noOfTransactions);
		return mav;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ModelAndView viewProduct(@Valid @ModelAttribute("transactionSearchHelper") StartEndDate transactionSearchHelper, BindingResult result,
			@PathVariable String id) throws ParseException {		
		Integer idi = Integer.parseInt(id);
		ModelAndView mav = new ModelAndView("viewProductTransaction");
		Product product = pService.findProduct(idi);
		Long noOfTransactions = tService.findNoOfTransaction(idi);
		mav.addObject("transactionL", noOfTransactions);
		if (!result.hasErrors())	{
		ArrayList<Transaction> transactions = tService.findTransactionByPartNumberAndDate(idi, transactionSearchHelper.getStartDate(), transactionSearchHelper.getEndDate());
		mav.addObject("transactionList", transactions);
		}
		mav.addObject("product", product);
		return mav;
	}

	 
	
	
}
