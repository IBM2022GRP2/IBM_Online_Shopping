package com.ibm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	public static int count = 100;
	@Id
	@Column(name="user_id")
	private int userId;
	@Column(name="user_name",length = 30)
	private String uname;
	@Column(name="email",length = 25, unique = true)
	private String email;
	@Column(name="pass",length=15)
	private String password;
	@Column(length = 10)
	private String phone_number;
	
//	@OneToMany(mappedBy = "userId")
	//private List<Order> user_order;
	
	@OneToMany(mappedBy = "uaid")
	private List<Address> user_add;
	
	@ManyToMany
	@JoinTable(name="couplink",
				joinColumns = @JoinColumn(name="user_id"),
				inverseJoinColumns = @JoinColumn(name="coupon_id"))
	private List<Coupon> ucoup;
	
	public int getUserId() {
		
		return userId;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", phone_number="
				+ phone_number + "]";
	}
	
	
}
