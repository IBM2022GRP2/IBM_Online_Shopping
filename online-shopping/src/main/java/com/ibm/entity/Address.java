package com.ibm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** This class represents generalized User Address.
 * 
 * @author ANIRBAN BHATTACHARYYA
 *
 */
@Entity
@Table(name="address")
public class Address {
	@Id
	private int addressId;
	@Column
	private int houseNo;
	@Column(length=15)
	private String street;
	@Column(length=10)
	private String city;
	@Column(length=10)
	private String state;
	@Column
	private int pincode;
	
//	@ManyToOne
//	@JoinColumn(name="uid")
//	private User user;
//	
//	@ManyToMany
//	@JoinColumn(name="oid")
//	private List<Order> order;

	
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public List<Order> getOrder() {
//		return order;
//	}
//
//	public void setOrder(List<Order> order) {
//		this.order = order;
//	}
	
	
	
	
}
