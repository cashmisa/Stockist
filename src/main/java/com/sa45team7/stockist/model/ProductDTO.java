package com.sa45team7.stockist.model;

public class ProductDTO {

	private int partNumber;

	private String brand;

	private int minOrderQty;

	private String partName;

	private double price;

	private int qty;

	private int reOrderQty;

	private String shelfLocation;

	private int supplierId;

	public ProductDTO() {

	}

	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getMinOrderQty() {
		return minOrderQty;
	}

	public void setMinOrderQty(int minOrderQty) {
		this.minOrderQty = minOrderQty;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getReOrderQty() {
		return reOrderQty;
	}

	public void setReOrderQty(int reOrderQty) {
		this.reOrderQty = reOrderQty;
	}

	public String getShelfLocation() {
		return shelfLocation;
	}

	public void setShelfLocation(String shelfLocation) {
		this.shelfLocation = shelfLocation;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public ProductDTO(Product product) {
		this.partNumber = product.getPartNumber();
		this.partName = product.getPartName();
		this.brand = product.getBrand();
		this.minOrderQty = product.getMinOrderQty();
		this.price = product.getPrice();
		this.qty = product.getQty();
		this.reOrderQty = product.getReOrderQty();
		this.shelfLocation = product.getShelfLocation();
		this.supplierId = product.getSupplier().getSupplierId();
	}
	
}
