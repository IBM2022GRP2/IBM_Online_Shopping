package com.ibm.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ibm.entity.Address;
import com.ibm.entity.Product;

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
	
	@Column(name="date");
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User void;
	
	@ManyToMany
	@JoinColumn(name="address_id")
	private Address addId;
	
	@ManyToMany
	@JoinTable(name="content")
	
	private List<Product> product_list = new ArrayList<>();

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Address getAddId() {
		return addId;
	}

	public void setAddId(Address addId) {
		this.addId = addId;
	}

	public List<Product> getProduct_list() {
		return product_list;
	}

	public void setProduct_list(List<Product> product_list) {
		this.product_list = product_list;
	}
	
	
	
}
