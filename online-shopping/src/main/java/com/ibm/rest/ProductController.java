package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ibm.entity.Product;
import com.ibm.exception.InvalidCartException;
import com.ibm.service.ProductServiceImpl;

@RestController
public class ProductController {
	@Autowired
private ProductServiceImpl service;
	
	@PostMapping(value="/add", consumes="application/json")
	public String save(@RequestBody Product p) {
		int pid =service.save(p);
		return "Product saved with id: " + pid;
	}
	@GetMapping(value="/fetch/{pid}",consumes="application/json")
	public Product fetch(@PathVariable int pid) {
		return service.fetch(pid);
	}
	

	
	@GetMapping(value="/list",consumes="application/json")
	public List<Product>list(){
		return service.list();
	}
	
	@GetMapping(value="/bycategory/{category}",consumes="application/json")
	public List<Product>findByCategory(@PathVariable String category){
		return service.byCategory(category);
	}
	
	
	@GetMapping(value="/byname/{pname}",consumes="application/json")
	public List<Product>findbyName(@PathVariable String pname) 
	{
	
			return service.byName(pname);
		
	}
	

	@GetMapping(value="/bypricerange",consumes="application/json")
	public List<Product>findByPriceRange(@RequestParam double lowp,@RequestParam double highp) {
	
			return service.byPriceRange(lowp, highp);
	
	}
	
}
