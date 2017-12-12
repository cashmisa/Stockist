package com.sa45team7.stockist.service;

import java.util.ArrayList;
import java.util.function.Predicate;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sa45team7.stockist.model.Product;
import com.sa45team7.stockist.model.ProductDTO;
import com.sa45team7.stockist.model.Supplier;
import com.sa45team7.stockist.repository.ProductRepository;
import com.sa45team7.stockist.repository.SupplierRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductRepository productRepository;

	@Resource
	private SupplierRepository supplierRepository;

	@Override
	@Transactional
	public ArrayList<Product> findProductList() {
		return (ArrayList<Product>) productRepository.findAll();
	}

	@Override
	@Transactional
	public ArrayList<Product> findProductListSorted() {
		return (ArrayList<Product>) productRepository.findAll(new Sort("partNumber"));
	}

	@Override
	@Transactional
	public Product findProduct(Integer id) {
		return productRepository.findOne(id);
	}

	@Override
	@Transactional
	public ArrayList<Product> findProductByName(String name) {
		return (ArrayList<Product>) productRepository.findProductByName(name);
	}

	@Override
	@Transactional
	public ArrayList<Product> findProductBySupplierId(Integer supplierId) {
		return (ArrayList<Product>) productRepository.findProductBySupplierId(supplierId);
	}

	@Override
	@Transactional
	public ArrayList<Product> findProductByBrand(String brand) {
		return (ArrayList<Product>) productRepository.findProductByBrand(brand);
	}

	@Override
	@Transactional
	public Product createProduct(Product product) {
		return productRepository.saveAndFlush(product);
	}

	@Override
	@Transactional
	public Product createProduct(ProductDTO productDTO) {
		Product product = new Product();
		product = convertToProduct(product, productDTO);
		return productRepository.saveAndFlush(product);
	}

	@Override
	@Transactional
	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}

	@Override
	@Transactional
	public Product updateProduct(Product product) {
		return productRepository.saveAndFlush(product);
	}

	@Override
	@Transactional
	public Product updateProduct(ProductDTO productDTO) {
		Product product = productRepository.findOne(productDTO.getPartNumber());
		product = convertToProduct(product, productDTO);
		return productRepository.saveAndFlush(product);
	}

	public Product convertToProduct(Product product, ProductDTO productDTO) {
		BeanUtils.copyProperties(productDTO, product);
		Supplier supplier = supplierRepository.findOne(productDTO.getSupplierId());
		product.setSupplier(supplier);
		return product;
	}

	@Override
	@Transactional
	public ArrayList<Integer> findAllPartNumber() {
		return productRepository.findPartNumber();
	}

	@Override
	@Transactional
	public ArrayList<Product> findProductByExample(ProductDTO productDTO) {
		ArrayList<Product> resultList = null;

		if (productDTO.getPartName() != "" || productDTO.getBrand() != "" || productDTO.getShelfLocation() != "") {
			Product product = new Product();

			product.setPartName(productDTO.getPartName().trim());
			product.setBrand(productDTO.getBrand().trim());
			product.setShelfLocation(productDTO.getShelfLocation().trim());

			ExampleMatcher matcher = ExampleMatcher.matching()
					.withIgnorePaths("partNumber", "minOrderQty", "price", "qty", "reOrderQty")
					.withMatcher("partName", match -> match.ignoreCase().contains())
					.withMatcher("brand", match -> match.ignoreCase().contains())
					.withMatcher("shelfLocation", match -> match.ignoreCase().contains());

			Example<Product> example = Example.of(product, matcher);

			resultList = (ArrayList<Product>) productRepository.findAll(example);
		}

		if (productDTO.getPartNumber() != 0) {
			String partNumber = String.valueOf(productDTO.getPartNumber());
			if (resultList == null) // if no result from ExampleQuery, use partNumber for query
			{
				resultList = productRepository.findByPartNumberContaining(partNumber);
			} else // filter current resultList with partNumber
			{
				Predicate<Product> filterByPartNumber = p -> !String.valueOf(p.getPartNumber()).contains(partNumber);
				resultList.removeIf(filterByPartNumber);
			}
		}

		return resultList;
	}

}
