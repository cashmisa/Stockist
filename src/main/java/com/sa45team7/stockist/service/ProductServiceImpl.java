package com.sa45team7.stockist.service;

import com.sa45team7.stockist.repository.ProductRepository;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.sa45team7.stockist.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Resource
	private ProductRepository productRepository;

	@Override
	@Transactional
	public ArrayList<Product> getProductList() {
		return (ArrayList<Product>) productRepository.findAll();
	}

	@Override
	@Transactional
	public Product findProduct(Integer id){
			return productRepository.findOne(id);
		}
	
	@Override
	@Transactional
	public ArrayList<Product> findProductByName(String name){
		return (ArrayList<Product>) productRepository.findProductByName(name);
	}
	
	@Override
	@Transactional
	public ArrayList<Product> findProductBySupplierId(Integer supplierId){
		return (ArrayList<Product>) productRepository.findProductBySupplierId(supplierId);
	}
	
	@Override
	@Transactional
	public ArrayList<Product> findProductByBrand(String brand){
		return (ArrayList<Product>) productRepository.findProductByBrand(brand);
	}
	

	@Override
	@Transactional
	public Product createProduct(Product product) {
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

}
