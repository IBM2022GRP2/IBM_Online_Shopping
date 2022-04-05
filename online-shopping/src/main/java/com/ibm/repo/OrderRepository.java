package com.ibm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	@Query("FROM Order Where user_id=:uid")
	List<Order> findAllByUser(int uid);

}
