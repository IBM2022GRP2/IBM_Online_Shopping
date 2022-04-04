package com.ibm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

/**
* @author Mrinal Samanta(@github - Mrinal_Delta)
* @since 0.0.1
**/

@Entity
@Table(name="Coupons")
public class Coupon {
	@Id
	@Column(name="coupon_id")
	private int cid;
	@Column(name="coupon_name")
	private String cname;
	@Column(name="discount")
	private double discount;
	
	@ManyToMany
	@JoinTable(name="couplink",
				joinColumns = @JoinColumn(name="coupon_id"),
				inverseJoinColumns = @JoinColumn(name="user_id"))
	private List<User> coupuser;
	

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public List<User> getCoupuser() {
		return coupuser;
	}

	public void setCoupuser(List<User> coupuser) {
		this.coupuser = coupuser;
	}
	
	
}
