package com.mikxingu.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mikxingu.domain.User;

@RestController()
@RequestMapping(value = "/users")
public class UserController {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria", "maria@gmail.com");
		User alex = new User("1", "Alex", "alex@gmail.com");
		
		List<User> users = new ArrayList<>();
		
		users.addAll(Arrays.asList(maria, alex));
		
		return ResponseEntity.ok().body(users);
	}
}
