package com.ibm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
<<<<<<< HEAD
	List<Product> findByCategory(String category);
	
	@Query("FROM Product WHERE price>=:lowp AND price<=highp")
	List<Product> findByPriceRange(double lowp,double highp);
=======
	
@Query("FROM Product WHERE price>=:lowp AND price<=:highp")	
List<Product> findByPriceRange(double lowp,double highp);	
	
List<Product>findByCategory(String category) ;

List<Product>findByPname(String pname);
 

>>>>>>> 129ba93609053dedf22fe5ed13b203bb06cac7e6
}
