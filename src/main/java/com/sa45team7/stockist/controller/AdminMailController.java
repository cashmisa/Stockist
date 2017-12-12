package com.sa45team7.stockist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sa45team7.stockist.mail.GmailOrderManager;

@RestController
public class AdminMailController {
	
	@Autowired
	GmailOrderManager orderManager;
	
	@GetMapping(value="/admin/mail/{supplierId}")
	public String sendMail(@PathVariable("supplierId") int id) {
		orderManager.placeOrder(id);
		return "Order is sent successfully";
	}
	
}
