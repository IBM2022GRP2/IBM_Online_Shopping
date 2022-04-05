package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Coupon;
import com.ibm.repo.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponRepository repo;
	
	@Override
	public int addCoupon(Coupon coupon) {
		repo.save(coupon);
		return coupon.getCid();
	}

	@Override
	public Coupon fetchCoupon(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Coupon> fetchAllCoupons() {
		return repo.findAll();
	}

}
