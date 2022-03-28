package com.ibm.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Product;
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
}
