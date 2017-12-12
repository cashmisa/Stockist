package com.sa45team7.stockist.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sa45team7.stockist.exception.SupplierNotFound;
import com.sa45team7.stockist.model.Supplier;
import com.sa45team7.stockist.service.SupplierService;
import com.sa45team7.stockist.validator.SupplierValidator;

@RequestMapping("/admin/supplier")
@Controller
public class AdminSupplierController {
	
	@Autowired
	private SupplierService sService;
	
	
	@Autowired
	private SupplierValidator sValidator;
	@InitBinder("supplier")
	private void initSupplierBinder(WebDataBinder binder) {
		binder.setValidator(sValidator);
	}
	
	
	/**
	 * supplier CRUD OPERATIONS
	 * 
	 * @return
	 */
	
	
	@RequestMapping(value = {"", "/list"}, method = RequestMethod.GET)
	public ModelAndView supplierListPage() {
		ModelAndView view = new ModelAndView("supplier-list");
		List<Supplier> supplierList = sService.findAllSuppliers();
		view.addObject("supplierList", supplierList);
		return view;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newSupplierPage() {
		ModelAndView view = new ModelAndView("supplier-new", "supplier", new Supplier());
		ArrayList<Integer> supplierIdList = sService.findAllSupplierIDs();
		view.addObject("supplierIdList", supplierIdList);
		return view;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewSupplier(@ModelAttribute @Valid Supplier supplier, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("supplier-new");

		ModelAndView view = new ModelAndView();
		String message = "New Supplier <strong>"+ supplier.getSupplierName()  +"</strong> was successfully added.";

		sService.createSupplier(supplier);
		view.setViewName("redirect:/admin/supplier/list");

		redirectAttributes.addFlashAttribute("message", message);
		return view;
	}

	

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editSupplierPage(@PathVariable Integer id) 
	{
		ModelAndView view = new ModelAndView("supplier-edit");
		Supplier supplier = sService.findSupplier(id);
		view.addObject("supplier", supplier);
		ArrayList<Integer> supplierIdlist = sService.findAllSupplierIDs();
		view.addObject("supplierIdList", supplierIdlist);
		return view;

	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editSupplier(@ModelAttribute @Valid Supplier supplier, BindingResult result,
			@PathVariable Integer id, final RedirectAttributes redirectAttributes)throws SupplierNotFound{

	   if (result.hasErrors())
		return new ModelAndView("supplier-edit");

		ModelAndView view = new ModelAndView("redirect:/admin/supplier/list");
		String message = "Supplier <strong>"+ supplier.getSupplierName()  +"</strong> was successfully updated.";

		sService.changeSupplier(supplier);

		redirectAttributes.addFlashAttribute("message", message);
		return view;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteSupplier(@PathVariable Integer id, final RedirectAttributes redirectAttributes)
			throws SupplierNotFound {

		ModelAndView view = new ModelAndView("redirect:/admin/supplier/list");
		Supplier supplier = sService.findSupplier(id);
		String message;
	if(supplier.getProducts().size()>0)
	{
		 String errorMessage= "Supplier <strong>"+ supplier.getSupplierName() +"</strong> cannot be deleted.";
		 redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
	}
	else
	{
		sService.removeSupplier(supplier);
		 message = "Supplier <strong> " + supplier.getSupplierName() + "</strong> was successfully deleted.";
		 redirectAttributes.addFlashAttribute("message", message);
	}
		
		
		return view;
	}

}
