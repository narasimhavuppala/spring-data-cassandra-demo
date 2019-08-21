package com.verizon.consumer.springdatacassandrademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.consumer.springdatacassandrademo.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping
	public User saveUser(@RequestBody User obj) {
		return this.service.saveUser(obj);
	}

}
