package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Product;
import com.ibm.exception.InvalidCartException;

import com.ibm.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository repo;

	//For Adding Products
	@Override
	public int save(Product p) {
		repo.save(p);
		return  p.getPid();

	}

	//Fetching products by their product id
	@Override
	public Product fetch(int pid) {// If not working then return null at end
		return repo.findById(pid).get();
		
	}

	//Getting the list of all products
	@Override
	public List<Product> list() {
		return repo.findAll();
	}	
	
	//Removing a product
	@Override
	public boolean remove(int pid) {
		repo.deleteById(pid);
		return true;
	}

	//Getting products by searching their category
	@Override
	public List<Product> byCategory(String category) {
		return repo.findByCategory(category);
	}

	//Getting products by searching product names
	@Override
	public List<Product> byName(String pname) throws InvalidCartException {
		// TODO Auto-generated method stub
		return repo.findByPname(pname);
	}

	//Getting products based on their prices
	@Override
	public List<Product> byPriceRange(double lowprice, double highprice)throws InvalidCartException {
		return repo.findByPriceRange(lowprice, highprice);
	}

}
