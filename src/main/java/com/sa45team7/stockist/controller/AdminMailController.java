package com.sa45team7.stockist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.sa45team7.stockist.mail.GmailOrderManager;
import com.sa45team7.stockist.model.Supplier;
import com.sa45team7.stockist.service.SupplierService;

@RestController
public class AdminMailController {
	
	@Autowired
	GmailOrderManager orderManager;
	
	@Autowired
	SupplierService supplierservice;
	
	@GetMapping(value="/admin/mail/{supplierId}")
	public ModelAndView sendMail(@PathVariable("supplierId") int id, @ModelAttribute Supplier supplier ) {
		orderManager.placeOrder(id);
		supplier = supplierservice.findSupplier(id);
		ModelAndView modelAndView = new ModelAndView("order-successful");
		modelAndView.addObject("message", "Reorder to supplier <strong>" + supplier.getSupplierName() + "</strong> is sent successfully!");
		return modelAndView;		
	}
	
}
