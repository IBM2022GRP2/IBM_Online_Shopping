package com.ibm.service;

import java.util.List;

import com.ibm.entity.Product;

public interface ProductService {
	int save(Product p);

	Product fetch(int pid);

	List<Product> list();

	boolean remove(int pid);
}
