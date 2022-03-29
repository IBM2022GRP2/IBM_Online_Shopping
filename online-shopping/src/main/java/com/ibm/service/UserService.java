package com.ibm.service;

import java.util.List;

import com.ibm.entity.User;

public interface UserService {
	int save(User u);
	
	User fetch(int id);
	
	List<User> list();
}
