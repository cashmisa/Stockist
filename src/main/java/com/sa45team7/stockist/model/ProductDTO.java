package com.sa45team7.stockist.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

public class ProductDTO {

	@NotNull
	@Min(0)
	private int partNumber;
	
	private String partNumberString;
	
	@NotNull
	@NotBlank
	private String partName;

	@NotNull
	@NotBlank
	private String brand;

	@NotNull
	@Min(1)
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
	@NotBlank
	@Size(min=2,max=2)
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
	
	public String getPartNumberString() {
		return partNumberString;
	}

	public void setPartNumberString(String partNumberString) {
		this.partNumberString = partNumberString;
	}

	public ProductDTO(Product product) {
		BeanUtils.copyProperties(product, this);
		this.supplierId = product.getSupplier().getSupplierId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + partNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDTO other = (ProductDTO) obj;
		if (partNumber != other.partNumber)
			return false;
		return true;
	}

	public ProductDTO(int partNumber, String partName, String brand, int supplierId, int qty, int minOrderQty,
			int reOrderQty, double price, String shelfLocation) {
		super();
		this.partNumber = partNumber;
		this.partName = partName;
		this.brand = brand;
		this.supplierId = supplierId;
		this.qty = qty;
		this.minOrderQty = minOrderQty;
		this.reOrderQty = reOrderQty;
		this.price = price;
		this.shelfLocation = shelfLocation;
	}
	
}
