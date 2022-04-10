package com.ibm.service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Coupon;
import com.ibm.entity.Order;
import com.ibm.entity.Product;
import com.ibm.entity.ShoppingCart;
import com.ibm.pojo.Items;
import com.ibm.pojo.UserProduct;
import com.ibm.repo.ShoppingCartRepository;
import com.ibm.util.ProductException;
import com.ibm.util.ShoppingCartException;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartServcie {

	@Autowired
	private ShoppingCartRepository repo;
	
	@Autowired
	private ProductService pserv;
	
	@Autowired
	private CouponService cserv;
	
	@Autowired
	private OrderService oserv;
	
	@Autowired
	private AddressService addserv;
	
	@Autowired 
	private UserService userserv;
	
	//used to create an shopping cart for an user for the first time
	@Override
	public int createCart(int uid) {
		ShoppingCart cart = new ShoppingCart();
		cart.setUser_cart(userserv.fetch(uid));
		repo.save(cart);
		return cart.getCartid();
	}
	
	@Override
	public ShoppingCart fetchCart(int uid) {
		return repo.findCartByUserId(uid);
	}
	
	@Override
	public List<Items> viewCart(int cartid) {
		return repo.viewCart(cartid);
	}
	
	@Override
	public double addToCart(UserProduct up) throws Exception {
		//getting a product from database
		Product p = pserv.fetchByID(up.getPid());
		//getting a cart by user id
		ShoppingCart cart = repo.findCartByUserId(up.getUid());
		
		if(p.getStock()<1) {
			throw new ProductException("Product Out of stock.");
		}
		else if(p == null){
			throw new ProductException("Product can't be found");
		}
		else if(cart.getShop_cart().contains(p)) {
			throw new ShoppingCartException("Can't add one product more than once");
		}
		else {
			//adding product to cart
			cart.getShop_cart().add(p);
			//updating product stock
			p.setStock(p.getStock()-1);
			//calculating total price
			cart.setTotal_price(p.getPrice()+cart.getTotal_price());
			//saving product details after shopping
			pserv.update(p);
			//saving the cart to database
			repo.save(cart);
			return cart.getTotal_price();
		}
}

	@Override
	public String checkout(int cid,int uid,int adid) throws Exception{
		ShoppingCart cart = repo.findCartByUserId(uid);
		if(cart.getShop_cart().iterator().next()!=null) {
			Coupon c = cserv.fetchCoupon(cid);
			double discounted_value = cart.getTotal_price()-((c.getDiscount()*cart.getTotal_price())/100);
			c.getCoup_user().add(userserv.fetch(uid));
			
			Order ord = new Order();
			ord.setOid(UUID.randomUUID().toString());
			ord.setDate(LocalDate.now());
			ord.setTotalprice(cart.getTotal_price());
			ord.setTotalprice(discounted_value);
			ord.setStatus("Paid");
			ord.setUserord(userserv.fetch(uid));
			ord.setAddOrd(addserv.getAddress(adid));
			ord.getProduct_list().addAll(cart.getShop_cart());
			oserv.addOrder(ord);
			
			cart.getShop_cart().clear();
			cart.setTotal_price(0);
			repo.save(cart);
			
			return ord.getOid();
		}
		else {
			throw new NoSuchElementException("Order can't be placed");
		}
		
	}

}
