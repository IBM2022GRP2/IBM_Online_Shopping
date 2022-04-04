package com.ibm.service;

import java.util.List;

import com.ibm.entity.Address;

public interface AddressService {
	
	int addAddress(Address a);
	
	Address getAddress(int aid);
	
	List<Address> listAllAddress();
	
//	List<Address> listAddress(int uid);
}
