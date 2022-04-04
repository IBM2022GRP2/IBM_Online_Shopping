package com.ibm.service;

import java.util.List;

import com.ibm.entity.Product;
import com.ibm.exception.InvalidCartException;


public interface ProductService {
	
	int save(Product p);
	
	Product fetch(int pid);
	
	List<Product> list();
	
	

	List<Product> byCategory(String category);

	List<Product>byName(String pname)throws InvalidCartException;

	List<Product>byPriceRange(double lowprice, double highprice);
}
