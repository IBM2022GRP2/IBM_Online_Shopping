package com.ibm.service;

import com.ibm.entity.Order;
import com.ibm.pojo.Items;
import com.ibm.repo.OrderRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository repo;
	
	@Override
	public String addOrder(Order ordr) {
		repo.save(ordr);
		return ordr.getOid();
	}
	
	@Override
	public Order getOrder(String oid) {
		return repo.findById(oid).get();
	}
	
	@Override
	public List<Order> fetchAllByUserId(int userid){
		return repo.findAllByUser(userid);
	}

	@Override
	public List<Items> viewProducts(String order_id) {
		return repo.viewProducts(order_id);
	}

}
