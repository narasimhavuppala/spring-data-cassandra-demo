package com.verizon.consumer.springdatacassandrademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.consumer.springdatacassandrademo.model.User;
import com.verizon.consumer.springdatacassandrademo.repo.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repo;
	
	public User saveUser(User obj) {
		return this.repo.save(obj);
	}

}
