package com.ibm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findByCategory(String category);
	
	@Query("FROM Product WHERE price>=:lowp AND price<=highp")
	List<Product> findByPriceRange(double lowp,double highp);
}
