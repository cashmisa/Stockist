package com.sa45team7.stockist.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa45team7.stockist.model.Product;
import com.sa45team7.stockist.model.ReportDTO;
import com.sa45team7.stockist.model.Supplier;
import com.sa45team7.stockist.repository.ProductRepository;
import com.sa45team7.stockist.repository.SupplierRepository;

@Service
public class ReorderServiceImpl implements ReorderService {

	@Autowired
	private ProductService pService;

	@Resource
	private ProductRepository pRepo;

	@Resource
	private SupplierRepository sRepo;

	/*
	 * If (reoderQty - qty < minQty) {orderAmount=minQty} else
	 * {orderAmount=reorderQty-qty} return a Map<Product, orderAmount> sorted by
	 * partNumber
	 */

	// jasper datasource DTO
	/* (non-Javadoc)
	 * @see com.sa45team7.stockist.service.ReorderService#getReorderReportList()
	 */
	@Override
	@Transactional
	public Collection<ReportDTO> getReorderReportList() {
		return getReportDTOList(getReorderProductList());
	}

	// jasper datasource DTO
	/* (non-Javadoc)
	 * @see com.sa45team7.stockist.service.ReorderService#getReorderReportListBySupplier(int)
	 */
	@Override
	@Transactional
	public Collection<ReportDTO> getReorderReportListBySupplier(int id) {
		return getReportDTOList(getReorderProductListBySupplier(id));
	}

	// jasper helper
	/* (non-Javadoc)
	 * @see com.sa45team7.stockist.service.ReorderService#getReorderProductList()
	 */
	@Override
	@Transactional
	public Collection<Product> getReorderProductList() {
		return pService.getProductListSorted();
	}

	// jasper helper
	/* (non-Javadoc)
	 * @see com.sa45team7.stockist.service.ReorderService#getReorderProductListBySupplier(int)
	 */
	@Override
	@Transactional
	public Collection<Product> getReorderProductListBySupplier(int id) {
		return pService.findProductBySupplierId(id);
	}

	// jasper helper method
	/* (non-Javadoc)
	 * @see com.sa45team7.stockist.service.ReorderService#getReportDTOList(java.util.Collection)
	 */
	@Override
	public Collection<ReportDTO> getReportDTOList(Collection<Product> pList) {
		Collection<ReportDTO> dtoList = new ArrayList<>();
		for (Product p : pList) {
			dtoList.add(getReportDTO(p));
		}
		return dtoList;
	}

	// jasper helper method
	/* (non-Javadoc)
	 * @see com.sa45team7.stockist.service.ReorderService#getReportDTO(com.sa45team7.stockist.model.Product)
	 */
	@Override
	public ReportDTO getReportDTO(Product p) {
		ReportDTO dto = new ReportDTO();
		//BeanUtils.copyProperties(p, dto, null,"supplier");
		dto.setPartNumber(p.getPartNumber());
		dto.setQty(p.getQty());
		dto.setMinOrderQty(p.getMinOrderQty());
		dto.setPrice(p.getPrice());
		dto.setReOrderQty(p.getReOrderQty());
		dto.setSupplierId(p.getSupplier().getSupplierId());
		dto.setSupplierName(p.getSupplier().getSupplierName());
		dto.setQtyToReorder(p.getQty() > p.getReOrderQty() ? 0
				: (p.getReOrderQty() - p.getQty() < p.getMinOrderQty() ? p.getMinOrderQty()
						: p.getReOrderQty() - p.getQty()));
		return dto;
	}

	// jsp page: get suppliers who have products
	/* (non-Javadoc)
	 * @see com.sa45team7.stockist.service.ReorderService#getSuppliersWithProducts()
	 */
	@Override
	public Collection<Supplier> getSuppliersWithProducts() {
		return sRepo.findSuppliersByIdList(pRepo.findSupplierIdsWithProducts());
	}

	// jsp page
	/* (non-Javadoc)
	 * @see com.sa45team7.stockist.service.ReorderService#getReorderProductMap()
	 */
	@Override
	@Transactional
	public LinkedHashMap<Product, Integer> getReorderProductMap() {
		return getReorderMap(pService.getProductListSorted());
	}

	// jsp page
	/* (non-Javadoc)
	 * @see com.sa45team7.stockist.service.ReorderService#getReoderProductMapBySupplier(int)
	 */
	@Override
	@Transactional
	public LinkedHashMap<Product, Integer> getReoderProductMapBySupplier(int id) {
		return getReorderMap(pService.findProductBySupplierId(id));
	}

	// jsp page
	/* (non-Javadoc)
	 * @see com.sa45team7.stockist.service.ReorderService#getReorderSumPrice(java.util.LinkedHashMap)
	 */
	@Override
	@Transactional
	public double getReorderSumPrice(LinkedHashMap<Product, Integer> map) {
		double sumPrice = 0;
		for (Product p : map.keySet()) {
			sumPrice += p.getPrice() * map.get(p);
		}
		return sumPrice;
	}

	/*
	 * Helper method passing a list of (sorted) products, return products and its
	 * respective orderAmount if it is 0, add it too
	 */
	private LinkedHashMap<Product, Integer> getReorderMap(ArrayList<Product> pList) {
		LinkedHashMap<Product, Integer> rMap = new LinkedHashMap<>();
		for (Product p : pList) {
			if (p.getQty() < p.getReOrderQty()) {
				rMap.put(p, (p.getReOrderQty() - p.getQty()) < p.getMinOrderQty() ? p.getMinOrderQty()
						: (p.getReOrderQty() - p.getQty()));
			} else {
				rMap.put(p, 0);
			}
		}
		return rMap;
	}

}
