package com.sa45team7.stockist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sa45team7.stockist.model.Product;
import com.sa45team7.stockist.service.ProductService;


@Controller
@RequestMapping(value = "/catalogue")
public class CatalogueController {
	//view all catalog and be able to search based on the criteria given
	//CHUAN KET
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView createNewBrowseCatalog()
	{
		ModelAndView view = new ModelAndView("browseCatalog");
		
		Product product = new Product();
		view.addObject("emptyProduct", product);
		
		//product.setPartNumber(10);
		//product.setPartName("  st    ");
		//product.setBrand("    m    ");		
		//view.addObject("productList", productService.findProductByCriteria(product));
		
		return view;
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView browseCatalog(@ModelAttribute("emptyProduct") Product product)
	{
		ModelAndView view = new ModelAndView("browseCatalog");
		view.addObject("productList", productService.findProductByCriteria(product));
		
		return view;
	}
}
