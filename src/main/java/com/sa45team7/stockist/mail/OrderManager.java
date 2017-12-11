package com.sa45team7.stockist.mail;

import java.util.Collection;

import com.sa45team7.stockist.model.Product;

public interface OrderManager {

	void placeOrder(Collection<Product> products);
}
