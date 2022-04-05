package com.ibm.service;

import java.util.List;

import com.ibm.entity.ShoppingCart;
import com.ibm.pojo.UserProduct;

public interface ShoppingCartServcie {
	
	int createCart(int uid);
	
	ShoppingCart fetchCart(int uid);
	
	List<Object> viewCart(int uid);
	
	double addToCart(UserProduct up) throws Exception;
	
	String checkout(int cid,int uid,int adid) throws Exception;
	
}
