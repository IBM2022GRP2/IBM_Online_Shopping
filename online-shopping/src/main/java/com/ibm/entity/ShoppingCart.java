package com.ibm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

/**
 * @author Mrinal Samanta(@github - Mrinal_Delta)
 * @since 0.0.1
 */
@Entity
@Table(name="shopping_cart")
public class ShoppingCart {
	@Id
	@Column(name="cart_id")
	private int cartid;
	private double price;
	
	//many-to-many relation b/w shoppingcart and product
	@ManyToMany
	@JoinTable(name="cartproduct",
				joinColumns = {@JoinColumn(name="cart_id")},
				inverseJoinColumns = {@JoinColumn(name="product_id")})
	private List<Product> shop_cart;
	
	@OneToOne
	@JoinColumn(name="user_id",referencedColumnName = "user_id")
	private User ucart;


	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public User getUcart() {
		return ucart;
	}

	public void setUcart(User ucart) {
		this.ucart = ucart;
	}
	
	
}
