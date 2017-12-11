package com.sa45team7.stockist.controller;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sa45team7.stockist.model.Product;
import com.sa45team7.stockist.model.Transaction;
import com.sa45team7.stockist.model.User;
import com.sa45team7.stockist.service.ProductService;
import com.sa45team7.stockist.service.TransactionService;
import com.sa45team7.stockist.service.UserService;




@RequestMapping("/usage/create")
@Controller
public class RecordUsageController {
	//record usage of different types (returned, received, used)
	//populate to transaction table and reduce product qty
	
	@Autowired
	TransactionService transactionService;
	ProductService PService;
	UserService UService;
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	//需要返还一个view的名字，对应空的页面
	//需要返回一个新的 空的transaction object
	public ModelAndView createUsage() {
		ModelAndView mav = new ModelAndView("create-record", "transaction", new Transaction());
		//ArrayList<Integer> productList = productService.findAllPartNumber();
		//mav.addObject("productList", productList);
		return mav;
	}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createUsage(@ModelAttribute @Valid Transaction transaction,@RequestParam("partNumber") Integer partNumber, BindingResult result,
			final RedirectAttributes redirectAttributes)
	{
		//需要获取填好后的transaction object
		//把这个trans 存入数据库
		//跳转页面到xxxx
		
		ModelAndView mav = new ModelAndView();
		transactionService.createTransaction(transaction);
		Product product = PService.findProduct(partNumber);
		transaction.setProduct(product);
		
		mav.setViewName("redirect:/viewproduct/{transaction.partNumber}");		
		String message = "New transaction " + transaction.getTransactionId() + " was successfully created.";
		mav.addObject("transaction", transaction);
		redirectAttributes.addFlashAttribute("message", message);
		return mav;	
	}
	
		
}

