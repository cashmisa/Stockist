package com.sa45team7.stockist.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

public class ProductDTO {

	@NotNull
	private int partNumber;
	
	@NotNull
	private String partName;

	@NotNull
	private String brand;

	@NotNull
	private int supplierId;

	@NotNull
	@Min(0)
	private int qty;
	
	@NotNull
	@Min(1)
	private int minOrderQty;

	@NotNull
	@Min(1)
	private int reOrderQty;
	
	@NotNull
	@Min((long) 0.1)
	private double price;

	@NotNull
	private String shelfLocation;

	public ProductDTO() {

	}

	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getMinOrderQty() {
		return minOrderQty;
	}

	public void setMinOrderQty(int minOrderQty) {
		this.minOrderQty = minOrderQty;
	}

	public int getReOrderQty() {
		return reOrderQty;
	}

	public void setReOrderQty(int reOrderQty) {
		this.reOrderQty = reOrderQty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getShelfLocation() {
		return shelfLocation;
	}

	public void setShelfLocation(String shelfLocation) {
		this.shelfLocation = shelfLocation;
	}

	public ProductDTO(Product product) {
		BeanUtils.copyProperties(product, this);
		this.supplierId = product.getSupplier().getSupplierId();
	}
	
}
