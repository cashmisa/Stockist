package com.sa45team7.stockist.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sa45team7.stockist.model.Product;
import com.sa45team7.stockist.model.ProductSearchDTO;
import com.sa45team7.stockist.service.ProductService;


@Controller
@RequestMapping(value = "/catalogue")
public class CatalogueController {
	//view all catalog and be able to search based on the criteria given
	//CHUAN KET
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value= {"", "/reset"}, method = RequestMethod.GET)
	public ModelAndView createNewBrowseCatalog()
	{
		ModelAndView view = new ModelAndView("browseCatalog");
		
		ProductSearchDTO productSearchDTO = new ProductSearchDTO();
		view.addObject("emptyProductSearchDTO", productSearchDTO);
		
		return view;
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView browseCatalog(@ModelAttribute("emptyProductSearchDTO") ProductSearchDTO productSearchDTO, BindingResult bindingResult)
	{
		ModelAndView view = new ModelAndView("browseCatalog");
		
		if(bindingResult.hasErrors())
		{
			return view;
		}
		
		view.addObject("productList", productService.findProductByCriteria(productSearchDTO));
		
		return view;
	}
	
	@RequestMapping(value= {"/all"}, method = RequestMethod.GET)
	public ModelAndView showAllProduct()
	{
		ModelAndView view = new ModelAndView("browseCatalog");
		
		ProductSearchDTO productSearchDTO = new ProductSearchDTO();
		
		view.addObject("emptyProductSearchDTO", productSearchDTO);
		view.addObject("productList", productService.getProductList());
		
		return view;
	}
}
