package com.sa45team7.stockist.model;

public class ReportDTO {
	
	private int partNumber;

	private int minOrderQty;

	private double price;

	private int qty;

	private int reOrderQty;
	
	private int qtyToReorder;
	
	private int supplierId;
	
	private String supplierName;

	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}


	public int getMinOrderQty() {
		return minOrderQty;
	}

	public void setMinOrderQty(int minOrderQty) {
		this.minOrderQty = minOrderQty;
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

	public int getQtyToReorder() {
		return qtyToReorder;
	}

	public void setQtyToReorder(int qtyToReorder) {
		this.qtyToReorder = qtyToReorder;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public ReportDTO() {
	}


	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
}
