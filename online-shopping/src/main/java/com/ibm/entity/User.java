package com.ibm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	public static int count = 100;
	@Id
	@Column
	@GeneratedValue
	private int userId;
	@Column(length = 25, unique = true)
	private String email;
	@Column
	private String password;
	@Column(length = 10)
	private String phone_number;
	public User() {
	}
	
	public User(String email, String password, String phone_number) {
		super();
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
	}

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
