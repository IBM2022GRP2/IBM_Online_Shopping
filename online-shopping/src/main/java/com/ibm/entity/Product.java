package com.ibm.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {
	@Id
	@Column(name = "product_Id")
	private int pid;
	@Column(name = "product_Name", length = 25)
	private String pname;
	@Column(name = "stock")
	private int stock;
	@Column(name = "price")
	private double price;
	@Column(name = "category",length=5)
	private String category;
public Product() {
}
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	public Product(int pid, String pname, int stock, double price, String category, List<Product> orders) {
		this.pid = pid;
		this.pname = pname;
		this.stock = stock;
		this.price = price;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", stock=" + stock + ", price=" + price + ", category="
				+ category + "]";
	}

}
