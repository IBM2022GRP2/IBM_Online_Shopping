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
	
	@GetMapping(value="/del/{pid}",consumes="application/json")
	public String remove(@PathVariable int pid) {
		service.remove(pid);
		return "Removed the Product having product id: "+pid;
	}
	
	@GetMapping(value="/list",consumes="application/json")
	public List<Product>list(){
		return service.list();
	}
	
	@GetMapping(value="/bycategory/{category}",consumes="application/json")
	public List<Product>findByCategory(@PathVariable String category){
		return service.byCategory(category);
	}
	
	//shows message if given product name is not in the products table 
	@GetMapping(value="/byname/{pname}",consumes="application/json")
	public List<Product>findbyName(@PathVariable String pname) throws InvalidCartException
	{
		try {
			return service.byName(pname);
		} catch (InvalidCartException e) {
			e.printStackTrace();
			throw new InvalidCartException("Sorry! We don't sell this product");
		}
	}
	
	//shows message if no product is found under this filter
	@GetMapping(value="/bypricerange",consumes="application/json")
	public List<Product>findByPriceRange(@RequestParam double lowp,@RequestParam double highp) throws InvalidCartException
	{
		try {
			return service.byPriceRange(lowp, highp);
		} catch (InvalidCartException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InvalidCartException("Sorry! Products not found matching your criteria");
		}	
	}
	{
		
	}
	
}
