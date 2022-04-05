package com.ibm.service;

import java.util.List;

import com.ibm.entity.Coupon;

public interface CouponService {
	int addCoupon(Coupon coupon);
	
	Coupon fetchCoupon(int id);
	
	List<Coupon> fetchAllCoupons();
}
