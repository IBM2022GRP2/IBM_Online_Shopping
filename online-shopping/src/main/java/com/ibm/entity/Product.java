package com.ibm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
* @author Arup Bhattacharjee(@github - 09arup06)
* @since 0.0.1
**/

@Entity
@Table(name = "Products")
public class Product {
	@Id
	@Column(name = "product_id")
	private int pid;
	@Column(name = "product_name", length = 25)
	private String pname;
	@Column(name = "stock")
	private int stock;
	@Column(name = "price")
	private double price;
	@Column(name = "category", length = 5)
	private String category;

	//many-to-many relation b/w shoppingcart and product
		@ManyToMany
		@JoinTable(name="cartp_roduct",
					joinColumns = {@JoinColumn(name="product_id")},
					inverseJoinColumns = {@JoinColumn(name="cart_id")})
	
	private List<ShoppingCart> pcart;
		
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
