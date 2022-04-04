package com.ibm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
<<<<<<< HEAD
=======

	
@Query("FROM Product WHERE price>=:lowp AND price<=:highp")	
List<Product> findByPriceRange(double lowp,double highp);	
	
List<Product>findByCategory(String category) ;
>>>>>>> 144dadc027710f75bc1195961d6ba920472aab2c

	@Query("FROM Product WHERE price>=:lowp AND price<=:highp")	
	List<Product> findByPriceRange(double lowp,double highp);	
		
	List<Product>findByCategory(String category) ;
	
	List<Product>findByPname(String pname);
 

}
