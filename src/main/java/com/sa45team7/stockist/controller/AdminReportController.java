package com.sa45team7.stockist.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sa45team7.stockist.model.Product;
import com.sa45team7.stockist.service.ReorderService;
import com.sa45team7.stockist.service.SupplierService;

@RequestMapping("/admin/report")
@Controller
public class AdminReportController {
	
	@Autowired
	ReorderService reorderService;
	
	@Autowired
	SupplierService supplierService;
	
	/*
	 * display a list of suppliers
	 */
	@RequestMapping(value= {"","/list"}, method=RequestMethod.GET)
	public ModelAndView ReorderListPage() {
		ModelAndView mav = new ModelAndView("reorder");
		mav.addObject("supplierList", supplierService.findAllSuppliers());
		return mav;
	}
	
	/*
	 * click on to generate reorder report for selected supplier
	 */
	
	@RequestMapping(value="/supplier/{supplierId}", method=RequestMethod.GET)
	public ModelAndView ReorderListBySupplier(@PathVariable("supplierId") int id) {
		ModelAndView mav = new ModelAndView("reorder-per-supplier");
		LinkedHashMap<Product, Integer> reorderList = reorderService.getReoderProductListBySupplier(id);
		mav.addObject("reorderList", reorderList);
		mav.addObject("supplierName", supplierService.findSupplier(id).getSupplierName());
		mav.addObject("sumPrice", reorderService.getReorderSumPrice(reorderList));
		return mav;
	}
	
	/*
	 * click on "full reorder list" and display all 
	 */
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ModelAndView ReorderListAllProducts() {
		ModelAndView mav = new ModelAndView("reorder-all-products");
		LinkedHashMap<Product, Integer> reorderList = reorderService.getReorderProductList();
		mav.addObject("reorderList", reorderList);
		mav.addObject("sumPrice", reorderService.getReorderSumPrice(reorderList));
		return mav;
	}

}
