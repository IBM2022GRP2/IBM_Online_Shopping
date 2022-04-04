/*package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.User;
import com.ibm.repo.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;
	@Override
	public int save(User u) {
		repo.save(u);
		return u.getUserId();
	}

	@Override
	public User fetch(int userId) {
		return repo.findById(userId).get();
	}  

	@Override
	public List<User> list() {
		return repo.findAll();
	}

}*/
