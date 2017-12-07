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

import com.sa45team7.exception.SupplierNotFound;
import com.sa45team7.stockist.model.Supplier;
import com.sa45team7.stockist.service.SupplierService;

@RequestMapping("/admin/supplier")
@Controller
public class AdminSupplierController {
	
	@Autowired
	private SupplierService sService;
	
	
	/*@Autowired
	private SupplierValidator sValidator;
	@InitBinder("supplier")
	private void initSupplierBinder(WebDataBinder binder) {
		binder.setValidator(sValidator);
	}*/
	
	
	/**
	 * supplier CRUD OPERATIONS
	 * 
	 * @return
	 */
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView supplierListPage() {
		ModelAndView mav = new ModelAndView("supplier-list");
		List<Supplier> supplierList = sService.findAllSuppliers();
		mav.addObject("supplierList", supplierList);
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newSupplierPage() {
		ModelAndView mav = new ModelAndView("supplier-new", "supplier", new Supplier());
		ArrayList<Integer> supplierIdList = sService.findAllSupplierIDs();
		mav.addObject("supplierIdList", supplierIdList);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewSupplier(@ModelAttribute @Valid Supplier supplier, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("supplier-new");

		ModelAndView mav = new ModelAndView();
		String message = "New Supplier " + supplier.getSupplierName() + " was successfully created.";

		sService.createSupplier(supplier);
		mav.setViewName("redirect:/admin/supplier/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editSupplierPage(@PathVariable Integer id) 
	{
		ModelAndView mav = new ModelAndView("supplier-edit");
		Supplier supplier = sService.findSupplier(id);
		mav.addObject("supplier", supplier);
		ArrayList<Integer> supplierIdlist = sService.findAllSupplierIDs();
		mav.addObject("supplierIdList", supplierIdlist);
		return mav;

	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editSupplier(@ModelAttribute @Valid Supplier supplier, BindingResult result,
			@PathVariable Integer id, final RedirectAttributes redirectAttributes)throws SupplierNotFound{

	   if (result.hasErrors())
		return new ModelAndView("supplier-edit");

		ModelAndView mav = new ModelAndView("redirect:/admin/supplier/list");
		String message = "Supplier was successfully updated.";

		sService.changeSupplier(supplier);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteSupplier(@PathVariable Integer id, final RedirectAttributes redirectAttributes)
			throws SupplierNotFound {

		ModelAndView mav = new ModelAndView("redirect:/admin/supplier/list");
		Supplier supplier = sService.findSupplier(id);
		sService.removeSupplier(supplier);
		String message = "The supplier " + supplier.getSupplierName() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
