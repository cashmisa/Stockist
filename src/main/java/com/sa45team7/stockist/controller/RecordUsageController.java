package com.sa45team7.stockist.controller;
import static org.assertj.core.api.Assertions.useDefaultDateFormatsOnly;


import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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




@RequestMapping("/usage")
@Controller
public class RecordUsageController {
	//record usage of different types (returned, received, used)
	//populate to transaction table and reduce product qty
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	ProductService PService;
	
	@Autowired
	UserService UService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	//需要返还一个view的名字，对应空的页面
	//需要返回一个新的 空的transaction object
	public ModelAndView createUsage() {
		ModelAndView mav = new ModelAndView("create-record", "transaction", new Transaction());
		//ArrayList<Integer> productList = productService.findAllPartNumber();
		//mav.addObject("productList", productList);
		ArrayList<String> typelist = transactionService.findAllTransactionType();
		mav.addObject("typelist", typelist);
		return mav;
	}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createUsage(@ModelAttribute @Valid Transaction transaction,
			BindingResult result,
			final RedirectAttributes redirectAttributes, HttpServletRequest request) throws Exception
	{
		// @RequestParam(value="partNumber") Integer partNumber
		//需要获取填好后的transaction object
		//把这个trans 存入数据库
		//跳转页面到xxxx
		Integer partNumber = 0;
		
		if(request.getParameter("partNumber") != "")
		{
		   partNumber = Integer.parseInt(request.getParameter("partNumber"));
		}
		else 
			{
			
				ModelAndView modelAndView = new ModelAndView("create-record");
				ArrayList<String> typelist = transactionService.findAllTransactionType();
				modelAndView.addObject("typelist", typelist);
				return modelAndView;	
		}
		
		if (result.hasErrors())
		{
			ModelAndView modelAndView = new ModelAndView("create-record");
			ArrayList<String> typelist = transactionService.findAllTransactionType();
			modelAndView.addObject("typelist", typelist);
			return modelAndView;
		}
		
		ModelAndView mav = new ModelAndView();
		
		//根据partNumber找到product，将product放入transaction
		
		Product product = PService.findProduct(partNumber);
		if(product == null)
		{
			ModelAndView modelAndView = new ModelAndView("create-record", "transaction", new Transaction());
			ArrayList<String> typelist = transactionService.findAllTransactionType();
			modelAndView.addObject("typelist", typelist);
			modelAndView.addObject("producterrorMsg", "Product not found");
			return modelAndView;
		}
		
		Integer newqty;
		if(transaction.getTransactionType().equals("Received")) 
		{
		    newqty = product.getQty()+transaction.getQty();
		
		}else
		{
			newqty = product.getQty()-transaction.getQty();
			if(newqty<0) 
			{
				ModelAndView modelAndView = new ModelAndView("create-record", "transaction", new Transaction());
				ArrayList<String> typelist = transactionService.findAllTransactionType();
				modelAndView.addObject("typelist", typelist);
				modelAndView.addObject("qtyerrorMsg", "Inventory shortage");
				return modelAndView;
			}
		}
		product.setQty(newqty);	
		
		
		transaction.setProduct(product);
		//根据userName找到user，将user放入transaction
		//String userName = (String) request.getAttribute("userName");
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		
		User user = UService.findUser(userName);
		transaction.setUser(user);
		
		Date now = new Date();
		transaction.setDate(now);
				
		transactionService.createTransaction(transaction);
		
		mav.setViewName("redirect:/viewproduct/" + partNumber);		
		String message = "New transaction " + transaction.getTransactionId() + " was successfully created.";
		
		//mav.addObject("transaction", transaction);
		
		redirectAttributes.addFlashAttribute("message", message);
		return mav;	
	}
	
		
}

