package com.sa45team7.stockist.controller;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sa45team7.stockist.model.Transaction;
import com.sa45team7.stockist.service.TransactionService;

import edu.iss.cats.model.User;


@RequestMapping("/usage")
@Controller
public class RecordUsageController {
	//record usage of different types (returned, received, used)
	//populate to transaction table and reduce product qty
	
	@Autowired
	TransactionService transactionService;
	
	@RequestMapping(value = "/creat",method = RequestMethod.GET)
	//需要返还一个view的名字，对应空的页面
	//需要返回一个新的 空的transaction object
	public ModelAndView createUsage() {
		ModelAndView mav = new ModelAndView("create-record", "transaction", new Transaction());
		return mav;
	}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createUsage(@ModelAttribute @Valid Transaction transaction, BindingResult result,
			final RedirectAttributes redirectAttributes)
	{
		//需要获取填好后的transaction object
		//把这个trans 存入数据库
		//跳转页面到xxxx
		ModelAndView mav = new ModelAndView();
		transactionService.createTransaction(transaction);
		mav.setViewName();
		String message = "New user " + transaction.getTransactionId() + " was successfully created.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;	
	}
	
		
}

