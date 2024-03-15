package com.mikxingu.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mikxingu.domain.User;
import com.mikxingu.dto.UserDTO;
import com.mikxingu.services.UserService;

@RestController()
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {

		List<User> users = userService.findAll();

		List<UserDTO> userDtos = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(userDtos);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {

		User obj = userService.findById(id);

		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> insert(@RequestBody UserDTO objDTO){
		User obj = userService.fromDTO(objDTO);
		
		obj = userService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
}