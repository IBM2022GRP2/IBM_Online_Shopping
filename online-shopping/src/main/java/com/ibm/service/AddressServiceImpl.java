package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Address;
import com.ibm.repo.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository repo;
	
	@Override
	public int addAddress(Address a) {
		repo.save(a);
		return a.getAddressId();
	}

	@Override
	public Address getAddress(int aid) {
		return repo.findById(aid).get();
	}

	@Override
	public List<Address> listAllAddress() {
		return repo.findAll();
	}

//	@Override
//	public List<Address> listAddress(int uid) {
//		return repo.findAllbyUserId(uid);
//	}
	
	

}
