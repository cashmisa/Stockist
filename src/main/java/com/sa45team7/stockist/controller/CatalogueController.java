package com.sa45team7.stockist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sa45team7.stockist.model.ProductDTO;
import com.sa45team7.stockist.service.ProductService;

@Controller
@RequestMapping(value = "/catalogue")
public class CatalogueController {
	// view all catalog and be able to search based on the criteria given

	@Autowired
	ProductService productService;

	@RequestMapping(value = { "", "/reset" }, method = RequestMethod.GET)
	public ModelAndView createNewBrowseCatalog() {
		ModelAndView mav = new ModelAndView("browse-catalogue");
		mav.addObject("productDTO", new ProductDTO());

		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView browseCatalog(@ModelAttribute ProductDTO productDTO) {
		ModelAndView mav = new ModelAndView("browse-catalogue");

		mav.addObject("productList", productService.findProductByExample(productDTO));

		return mav;
	}

	@RequestMapping(value = { "/all" }, method = RequestMethod.GET)
	public ModelAndView showAllProduct() {
		ModelAndView mav = new ModelAndView("browse-catalogue");

		mav.addObject("productDTO", new ProductDTO());
		mav.addObject("productList", productService.findProductList());

		return mav;
	}
}
