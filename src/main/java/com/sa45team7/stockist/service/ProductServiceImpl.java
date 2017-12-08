package com.sa45team7.stockist.service;

import com.sa45team7.stockist.repository.ProductRepository;
import com.sa45team7.stockist.repository.SupplierRepository;

import java.util.ArrayList;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.sa45team7.stockist.model.Product;
import com.sa45team7.stockist.model.ProductDTO;
import com.sa45team7.stockist.model.ProductSearchDTO;
import com.sa45team7.stockist.model.Supplier;

@Service
public class ProductServiceImpl implements ProductService
{
	
	@Resource
	private ProductRepository productRepository;
	
	@Resource
	private SupplierRepository supplierRepository;
	
	
	@Override
	@Transactional
	public ArrayList<Product> getProductList()
	{
		return (ArrayList<Product>) productRepository.findAll();
	}
	
	
	@Override
	@Transactional
	public Product findProduct(Integer id)
	{
		return productRepository.findOne(id);
	}
	
	
	@Override
	@Transactional
	public ArrayList<Product> findProductByName(String name)
	{
		return (ArrayList<Product>) productRepository.findProductByName(name);
	}
	
	
	@Override
	@Transactional
	public ArrayList<Product> findProductBySupplierId(Integer supplierId)
	{
		return (ArrayList<Product>) productRepository.findProductBySupplierId(supplierId);
	}
	
	
	@Override
	@Transactional
	public ArrayList<Product> findProductByBrand(String brand)
	{
		return (ArrayList<Product>) productRepository.findProductByBrand(brand);
	}
	
	
	@Override
	@Transactional
	public Product createProduct(Product product)
	{
		return productRepository.saveAndFlush(product);
	}
	
	@Override
	@Transactional
	public Product createProduct(ProductDTO productDTO)
	{
		Product product = new Product();
		product = convertToProduct(product, productDTO);
		return productRepository.saveAndFlush(product);
	}
	
	
	@Override
	@Transactional
	public void deleteProduct(Product product)
	{
		productRepository.delete(product);
	}
	
	
	@Override
	@Transactional
	public Product updateProduct(Product product)
	{
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
		product.setPartNumber(productDTO.getPartNumber());
		product.setPartName(productDTO.getPartName());
		product.setBrand(productDTO.getBrand());
		product.setMinOrderQty(productDTO.getMinOrderQty());
		product.setPrice(productDTO.getPrice());
		product.setQty(productDTO.getQty());
		product.setReOrderQty(productDTO.getReOrderQty());
		product.setShelfLocation(productDTO.getShelfLocation());
		Supplier supplier = supplierRepository.findOne(productDTO.getSupplierId());
		product.setSupplier(supplier);
		return product;
	}
	
	@Override
	public ArrayList<Product> findProductByCriteria(ProductSearchDTO productSearchDTO)
	{
		ArrayList<Product> resultList = null;
		
		boolean first = true;
		
		if (productSearchDTO.getPartNumber() != "")
		{
			String partNumber = productSearchDTO.getPartNumber().toLowerCase().trim();
			
			if (first)
			{
				resultList = productRepository.findByPartNumberContaining(partNumber);
				first = false;
			}
		}
		
		if (productSearchDTO.getPartName() != "")
		{
			String partName = productSearchDTO.getPartName().toLowerCase().trim();
			
			if (first)
			{
				resultList = productRepository.findByPartNameContaining(partName);
				first = false;
			}
			else
			{
				Predicate<Product> filterByPartName = p -> !p.getPartName().toLowerCase().trim().contains(partName);
				resultList.removeIf(filterByPartName);
			}
		}
		
		if (productSearchDTO.getBrand() != "")
		{
			String brand = productSearchDTO.getBrand().toLowerCase().trim();
			
			if (first)
			{
				resultList = productRepository.findByBrandContaining(brand);
				first = false;
			}
			else
			{
				Predicate<Product> filterByBrand = p -> !p.getBrand().toLowerCase().trim().contains(brand);
				resultList.removeIf(filterByBrand);
			}
		}
		
		
		if (productSearchDTO.getShelfLocation() != "")
		{
			String shelfLocation = productSearchDTO.getShelfLocation().toLowerCase().trim();
			
			if (first)
			{
				resultList = productRepository.findByShelfLocationContaining(shelfLocation);
				first = false;
			}
			else
			{
				Predicate<Product> filterByShelf = p -> !p.getShelfLocation().toLowerCase().trim().contains(shelfLocation);
				resultList.removeIf(filterByShelf);
			}
		}
		
			
		return resultList;
	}
	
}
