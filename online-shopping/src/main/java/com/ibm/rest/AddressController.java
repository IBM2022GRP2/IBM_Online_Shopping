package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Address;
import com.ibm.service.AddressService;

/** This class represents Address Controller.
 * 
 *
 */
@RestController
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@PostMapping(value="/addAddress",consumes="application/json")
	public String save(@RequestBody Address a) {
		int aid=service.addAddress(a);
		return "Address saved with Id: " + aid;
	}
	
	@GetMapping(value="/getAddress/{aid}",produces="application/json")
	public Address find(@PathVariable int aid) {
		return service.getAddress(aid);
	}
	
	@GetMapping(value="/listAddresses",produces="application/json")
	public List<Address> listAllAddress() {
		return service.listAllAddress();
	}
	
//	@GetMapping(value="/getAddresses",produces="application/json")
//	public List<Address> list(int uid){
//		return service.listAddress(uid);
//	}
}
