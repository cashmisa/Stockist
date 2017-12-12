package com.sa45team7.stockist.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the transaction database table.
 * 
 */
@Entity
@NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t")
@Table(name = "transaction")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;

	private String customer;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private int qty;

	private String remarks;

	private String transactionType;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "userName")
	private User user;

	// bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name = "partNumber")
	private Product product;

	@Transient
	private int partNumber;

	public Transaction() {
	}

	public int getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getCustomer() {
		return this.customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getPartNumber() {
		return this.partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

}