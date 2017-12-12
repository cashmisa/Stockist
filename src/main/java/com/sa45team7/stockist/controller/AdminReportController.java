package com.sa45team7.stockist.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.sa45team7.stockist.model.Product;
import com.sa45team7.stockist.service.ReportService;
import com.sa45team7.stockist.service.SupplierService;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RequestMapping("/admin/report")
@Controller
public class AdminReportController {

	@Autowired
	ReportService rService;

	@Autowired
	SupplierService sService;
	
	@Autowired
	ApplicationContext appContext;

	/*
	 * display a list of active suppliers (who has products with us)
	 */
	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public ModelAndView ReorderListPage() {
		ModelAndView mav = new ModelAndView("reorder");
		mav.addObject("supplierList", rService.findSuppliersWithProducts());
		return mav;
	}

	/*
	 * display reorder overview for a given supplier
	 */
	@RequestMapping(value = "/supplier/{supplierId}", method = RequestMethod.GET)
	public ModelAndView reorderListBySupplier(@PathVariable("supplierId") int id) {
		ModelAndView mav = new ModelAndView("reorder-per-supplier");
		Map<Product, Integer> reorderList = rService.findReoderQtyMapBySupplier(id);
		mav.addObject("reorderList", reorderList);
		mav.addObject("supplierName", sService.findSupplier(id).getSupplierName());
		mav.addObject("supplierId", id);
		mav.addObject("sumPrice", rService.getReorderSumPrice(reorderList));
		return mav;
	}

	/*
	 * display all products' reorder overview
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView reorderListAllProducts() {
		ModelAndView mav = new ModelAndView("reorder-all-products");
		Map<Product, Integer> reorderMap = rService.findReorderQtyMap();
		mav.addObject("reorderMap", reorderMap);
		mav.addObject("sumPrice", rService.getReorderSumPrice(reorderMap));
		return mav;
	}
	
	/*
	 * providing pdf report for all products' reorder
	 */
	@RequestMapping(value = "/allpdf", method = RequestMethod.GET)
	public ModelAndView reorderPdfAllProducts() {
	    JasperReportsPdfView view = new JasperReportsPdfView();
	    view.setUrl("classpath:ReorderReport.jrxml");
	    view.setApplicationContext(appContext);
	    JRBeanCollectionDataSource jrds = new JRBeanCollectionDataSource(rService.findReorderDTOList());
	    return new ModelAndView(view, "productData", jrds);
	}
	
	/*
	 * providing pdf report for products' reorder for a given supplier
	 */
	@RequestMapping(value = "/supplierpdf/{supplierId}", method = RequestMethod.GET)
	public ModelAndView reorderPdftBySupplier(@PathVariable("supplierId") int id) {
		JasperReportsPdfView view = new JasperReportsPdfView();
	    view.setUrl("classpath:ReorderReportPerSupplier.jrxml");
	    view.setApplicationContext(appContext);
	    JRBeanCollectionDataSource jrds = new JRBeanCollectionDataSource(rService.findReorderDTOListBySupplier(id));
	    return new ModelAndView(view, "productData", jrds);
	}
}
