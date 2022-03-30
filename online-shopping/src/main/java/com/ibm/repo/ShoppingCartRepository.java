package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.entity.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

}
