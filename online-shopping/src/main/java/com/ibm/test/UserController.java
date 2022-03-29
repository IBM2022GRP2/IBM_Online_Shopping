package com.ibm.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.User;
import com.ibm.service.UserServiceImpl;

@RestController
public class UserController {
	@Autowired
	private UserServiceImpl service;

	@PostMapping(value = "/signup", consumes="application/json")
	
	public String save(@RequestBody User u) {
		int uid =service.save(u);
		return "Product saved with id: " + uid;
	}
	@GetMapping(value = "/fetchuser/{userId}", consumes="application/json")
	public User fetch(@PathVariable int userId) {
		return service.fetch(userId);
	}
	@GetMapping(value="/listuser",consumes="application/json")
	public List<User>list(){
		return service.list();
	}
}
