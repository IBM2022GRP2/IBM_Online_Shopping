package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ibm.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
