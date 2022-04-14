package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.User;
import com.ibm.repo.UserRepository;
import com.ibm.service.EmailServiceImpl;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private EmailServiceImpl emailservice;
	
	@Override
	public int save(User u) {
		repo.save(u);
//		emailservice.setReceiver(u.getEmail());
//		emailservice.setBody("Hi "+u.getUsername()+" ! \n Welcome to our webiste Fragnance World. " );
//		emailservice.setSubject("Welcome to Fragnance World");
		String msg = "Hi "+u.getUsername()+" ! \n Welcome to our webiste Fragnance World. " ;
		String sub= "Welcome to Fragnance World";
		emailservice.sendEmail(u.getEmail(),sub,msg);
		return u.getUserId();
	}

	@Override
	public boolean update(User u) {
		repo.save(u);
		return true;
	}

	@Override
	public User fetch(int userId) {
		return repo.findById(userId).get();
	}  

	@Override
	public List<User> list() {
		return repo.findAll();
	}


	@Override
	public User validate(String email, String password) {
		return repo.validate(email, password);
	}

}
