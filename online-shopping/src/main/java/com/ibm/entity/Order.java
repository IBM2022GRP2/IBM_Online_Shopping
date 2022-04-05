package com.ibm.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/* This class represents Order Entity.*/
 
@Entity
@Table(name="Orders")
public class Order {
	@Id
	@Column(name="order_id")
	private String oid;
	
	@Column(name="total_price")
	private double totalprice;
	
	@Column(name="status")
	private String status;
	
	@Column(name="date")
	private LocalDate date;
	
	//many to one relation b/w order and user
	@ManyToOne
	@JoinColumn(name="user_id")
	private User userord;
	
	//many to one relation b/w order and address
	@ManyToOne
	@JoinColumn(name="address_id")
	private Address addOrd;
	
	//many to many b/w order and products
	@ManyToMany
	@JoinTable(name="ordered_products",
				joinColumns = {@JoinColumn(name = "order_id")},
				inverseJoinColumns = {@JoinColumn(name="product_id")})
	private List<Product> product_list = new ArrayList<>();

	//for order_id
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}

	//for total_price
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	//for status
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	//for date
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	//for user_id
	public User getUserord() {
		return userord;
	}
	public void setUserord(User userord) {
		this.userord = userord;
	}

	//for address_id
	public Address getAddOrd() {
		return addOrd;
	}
	public void setAddOrd(Address addOrd) {
		this.addOrd = addOrd;
	}

	//for list of products in a order
	public List<Product> getProduct_list() {
		return product_list;
	}
	public void setProduct_list(List<Product> product_list) {
		this.product_list = product_list;
	}
	
	
	
}
