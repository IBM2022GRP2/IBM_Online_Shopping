package main.java.com.ibm.service;

import java.util.List;

import com.ibm.entity.Order;

public interface OrderService {
	String addOrder(Order ordr);
	
	List<Order>  fetchAllByUserId(int uid);

}
