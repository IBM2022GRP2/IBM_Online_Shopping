package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.User;
import com.ibm.pojo.Login;
import com.ibm.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value="User")
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping(value="/signup", consumes="application/json")
	public String save(@RequestBody User u) {
		int uid =service.save(u);
		return "User saved with id: " + uid;
	}
	
	@PutMapping(value="/update",consumes="application/json")
	public String update(@RequestBody User u) {
		if(service.update(u)) {
			return "Successfully Updated Profile";
		}
		else
			return "Unsuccessfull";
	}
	
	@GetMapping(value = "/fetchuser/{userId}", produces="application/json")
	public User fetch(@PathVariable int userId) {
		return service.fetch(userId);
	}
	
	@GetMapping(value="/listuser",produces="application/json")
	public List<User> list(){
		return service.list();
	}
	
	@PostMapping(value="/login",consumes="application/json")
	public User validate(@RequestBody Login l){
		return service.validate(l.getEmail(), l.getPass());
	}
}
