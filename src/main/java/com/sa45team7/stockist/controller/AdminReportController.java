package com.sa45team7.stockist.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.sa45team7.stockist.model.Product;
import com.sa45team7.stockist.service.ReorderService;
import com.sa45team7.stockist.service.SupplierService;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RequestMapping("/admin/report")
@Controller
public class AdminReportController {

	@Autowired
	ReorderService reorderService;

	@Autowired
	SupplierService supplierService;
	
	@Autowired
	ApplicationContext appContext;

	/*
	 * display a list of suppliers
	 */
	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public ModelAndView ReorderListPage() {
		ModelAndView mav = new ModelAndView("reorder");
		mav.addObject("supplierList", supplierService.findAllSuppliers());
		return mav;
	}

	/*
	 * click on to generate reorder report for selected supplier
	 */

	@RequestMapping(value = "/supplier/{supplierId}", method = RequestMethod.GET)
	public ModelAndView reorderListBySupplier(@PathVariable("supplierId") int id) {
		ModelAndView mav = new ModelAndView("reorder-per-supplier");
		LinkedHashMap<Product, Integer> reorderList = reorderService.getReoderProductMapBySupplier(id);
		mav.addObject("reorderList", reorderList);
		mav.addObject("supplierName", supplierService.findSupplier(id).getSupplierName());
		mav.addObject("supplierId", id);
		mav.addObject("sumPrice", reorderService.getReorderSumPrice(reorderList));
		return mav;
	}

	/*
	 * click on "full reorder list" and display all
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView reorderListAllProducts() {
		ModelAndView mav = new ModelAndView("reorder-all-products");
		LinkedHashMap<Product, Integer> reorderMap = reorderService.getReorderProductMap();
		mav.addObject("reorderMap", reorderMap);
		mav.addObject("sumPrice", reorderService.getReorderSumPrice(reorderMap));
		return mav;
	}
	
	@RequestMapping(value = "/allpdf", method = RequestMethod.GET)
	public ModelAndView reorderPdfAllProducts() {
	    JasperReportsPdfView view = new JasperReportsPdfView();
	    view.setUrl("classpath:ReorderReport.jrxml");
	    view.setApplicationContext(appContext);
	    JRBeanCollectionDataSource jrds = new JRBeanCollectionDataSource(reorderService.getReorderProductList());
	    return new ModelAndView(view, "productData", jrds);
	}
	
	@RequestMapping(value = "/supplierpdf/{supplierId}", method = RequestMethod.GET)
	public ModelAndView ReorderPdftBySupplier(@PathVariable("supplierId") int id) {
		JasperReportsPdfView view = new JasperReportsPdfView();
	    view.setUrl("classpath:ReorderReportPerSupplier.jrxml");
	    view.setApplicationContext(appContext);
	    JRBeanCollectionDataSource jrds = new JRBeanCollectionDataSource(reorderService.getReorderProductListBySupplier(id));
	    return new ModelAndView(view, "productData", jrds);
	}
}
