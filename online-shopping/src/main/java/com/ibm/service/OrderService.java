package com.ibm.service;

import java.util.List;

import com.ibm.entity.Order;
import com.ibm.pojo.Items;

public interface OrderService {
	String addOrder(Order ordr);
	
	List<Order>  fetchAllByUserId(int uid);

	List<Items> viewProducts(String order_id);
}
