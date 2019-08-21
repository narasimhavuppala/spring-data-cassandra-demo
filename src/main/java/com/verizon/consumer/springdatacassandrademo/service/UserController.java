package com.verizon.consumer.springdatacassandrademo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.utils.UUIDs;
import com.verizon.consumer.springdatacassandrademo.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService service;

	@PostMapping
	@Nullable
	public ResponseEntity<User> saveUser(@RequestBody @Nullable User obj) {
		
		obj.setLastLogin(UUID.randomUUID());
		
		System.out.println(UUID.randomUUID());
		
		System.out.println(UUIDs.timeBased());
		
		User entity= this.service.saveUser(obj);
		return new ResponseEntity<>(entity,HttpStatus.CREATED);
	}

	@GetMapping
	public List<User> getAllusers() {
		return this.service.getAllUsers();
	}
	
	@DeleteMapping
	@RequestMapping("/{userId}/{name}")
	public ResponseEntity<String> deleteById(@PathVariable("userId") Long userId,@PathVariable("name") String name) {
		this.service.deleteById(userId,name);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
