package com.ibm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.entity.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

	@Query("FROM ShoppingCart WHERE user_id=:uid")
	ShoppingCart findCartByUserId(int uid);
	
	@Query(value="SELECT Product.product_name,Product.category,Product.product_price FROM Product "
			+ "INNER JOIN cartproduct ON cartproduct.cart_id=:cartid "
			+ "AND Product.product_id=cartproduct.product_id",nativeQuery = true)
	List<Object> viewCart(int cartid);
}
