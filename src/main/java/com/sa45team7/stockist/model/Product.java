package com.sa45team7.stockist.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
@Table(name="product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int partNumber;

	private String brand;

	private int minOrderQty;

	private String partName;

	private double price;

	private int qty;

	private int reOrderQty;

	private String shelfLocation;

	//bi-directional many-to-one association to Supplier
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="supplierId")
	private Supplier supplier;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="product")
	private List<Transaction> transactions;

	public Product() {
	}

	public int getPartNumber() {
		return this.partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getMinOrderQty() {
		return this.minOrderQty;
	}

	public void setMinOrderQty(int minOrderQty) {
		this.minOrderQty = minOrderQty;
	}

	public String getPartName() {
		return this.partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getReOrderQty() {
		return this.reOrderQty;
	}

	public void setReOrderQty(int reOrderQty) {
		this.reOrderQty = reOrderQty;
	}

	public String getShelfLocation() {
		return this.shelfLocation;
	}

	public void setShelfLocation(String shelfLocation) {
		this.shelfLocation = shelfLocation;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setProduct(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setProduct(null);

		return transaction;
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
		Product other = (Product) obj;
		if (partNumber != other.partNumber)
			return false;
		return true;
	}

}