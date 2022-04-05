package com.ibm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** This class represents generalized User Address.
 * 
 * @author ANIRBAN BHATTACHARYYA
 *
 */
@Entity
@Table(name="Address")
public class Address {
	@Id
	@Column(name="address_id")
	private int addressId;
	@Column(name = "house_no")
	private int houseNo;
	@Column(length=20)
	private String street;
	@Column(length=20)
	private String city;
	@Column(length=20)
	private String state;
	@Column
	private int pincode;
	
	//many to one b/w address and user
	@ManyToOne
	@JoinColumn(name="user_id")
	private User useradd;
	
	//one to many relation b/w order and address
	@OneToMany(mappedBy="addOrd")
	private List<Order> ads_orders = new ArrayList<>();

	//for address_id
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	//for house_no
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	//for street
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

	//for city
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	//for state
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	//for pincode
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	//for user_id
	public User getUseradd() {
		return useradd;
	}
	public void setUseradd(User useradd) {
		this.useradd = useradd;
	}

	//for orders in a address
	public List<Order> getAds_orders() {
		return ads_orders;
	}

	public void setAds_orders(List<Order> ads_orders) {
		this.ads_orders = ads_orders;
	}

	
}
