package com.ibm.service;

import java.util.List;

import com.ibm.entity.Product;

public interface ProductService {
	int save(Product p);

	Product fetch(int pid);

	List<Product> list();

	boolean remove(int pid);
	
	List<Product> byCategory(String category);
	List<Product>byName(String pname);
	List<Product>byPriceRange(double lowprice, double highprice);
}
