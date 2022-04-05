package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Order;

import com.ibm.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping(value="Order")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping(value="/get/{uid}", produces="application/json")
	public List<Order> fetchOrders(@PathVariable int uid){
		return service.fetchAllByUserId(uid);
	}

}
