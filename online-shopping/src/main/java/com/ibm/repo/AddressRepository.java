package com.ibm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.entity.Address;


/** This interface represents Address Repository.
 * 
 *
 */
public interface AddressRepository extends JpaRepository<Address, Integer>{
	
//	List<Address> findAllbyUserId(int uid);
	
}
