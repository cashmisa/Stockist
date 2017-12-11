package com.sa45team7.stockist.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sa45team7.stockist.exception.ProductNotFound;
import com.sa45team7.stockist.model.Product;
import com.sa45team7.stockist.model.ProductDTO;
import com.sa45team7.stockist.service.ProductService;
import com.sa45team7.stockist.service.SupplierService;
import com.sa45team7.stockist.validator.ProductValidator;

@RequestMapping("/admin/product")
@Controller
public class AdminProductController {

	// RAJE

	@Autowired
	private ProductService pService;

	@Autowired
	private SupplierService sService;

	@Autowired
	private ProductValidator pValidator;

	@InitBinder("productDTO")
	private void InitProductBinder(WebDataBinder binder) {
		binder.setValidator(pValidator);
	}

	// product CRUD OPERATIONS

	@GetMapping(value = { "", "/list" })
	public ModelAndView ProductListPage() {
		ModelAndView mav = new ModelAndView("product-list");
		List<Product> productList = pService.findProductList();
		mav.addObject("productList", productList);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newProductPage() {
		ModelAndView mav = new ModelAndView("product-new", "productDTO", new ProductDTO());
		mav.addObject("suppliersList", sService.findAllSuppliers());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewProduct(@ModelAttribute @Valid ProductDTO productDTO, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("product-new");
			mav.addObject("suppliersList", sService.findAllSuppliers());
			return mav;
		}
		

		ModelAndView mav = new ModelAndView();
		
		pService.createProduct(productDTO);
		
		mav.setViewName("redirect:/admin/product/list");
		String message = "New Product <strong>"+ productDTO.getPartName()  +"</strong> was successfully added.";
		redirectAttributes.addFlashAttribute("message", message);
		
		return mav;
	}
	

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editProductPage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("product-edit");
		ProductDTO productDTO = new ProductDTO(pService.findProduct(id));
		mav.addObject("productDTO", productDTO);
		mav.addObject("suppliersList", sService.findAllSuppliers());
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editProduct(@ModelAttribute("productDTO") @Valid ProductDTO productDTO, BindingResult result,
			@PathVariable Integer id, final RedirectAttributes redirectAttributes) throws ProductNotFound {

		if (result.hasErrors()) {
			
			ModelAndView mav = new ModelAndView("product-edit");
			mav.addObject("suppliersList", sService.findAllSuppliers());
			return mav;
		}

		ModelAndView mav = new ModelAndView("redirect:/admin/product/list");
		
		pService.updateProduct(productDTO);
		
		String message = "Product <strong>"+ productDTO.getPartName()  +"</strong> was successfully updated.";
		
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	

	@GetMapping(value = "/delete/{id}")
	public ModelAndView deleteProduct(@PathVariable Integer id, final RedirectAttributes redirectAttributes)
			throws ProductNotFound {

		ModelAndView view = new ModelAndView("redirect:/admin/product/");
		Product product = pService.findProduct(id);
		pService.deleteProduct(product);

		String message = "Product <strong>" + product.getPartName() + "</strong> was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return view;
	}
}
