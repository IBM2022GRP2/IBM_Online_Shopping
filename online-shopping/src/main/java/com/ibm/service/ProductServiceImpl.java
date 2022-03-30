package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Product;
import com.ibm.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository repo;

	@Override
	public int save(Product p) {
		repo.save(p);
		return  p.getPid();

	}

	@Override
	public Product fetch(int pid) {// If not working then return null at end
		return repo.findById(pid).get();
		
	}

	@Override
	public List<Product> list() {
		return repo.findAll();
	}

	@Override
	public boolean remove(int pid) {
		repo.deleteById(pid);
		return true;
	}

	@Override
	public List<Product> byCategory(String category) {
		return repo.findByCategory(category);
	}

	@Override
	public List<Product> byName(String pname) {
		// TODO Auto-generated method stub
		return repo.findByPname(pname);
	}

	@Override
	public List<Product> byPriceRange(double lowprice, double highprice) {
		return repo.findByPriceRange(lowprice, highprice);
	}

}
