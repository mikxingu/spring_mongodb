package com.mikxingu.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikxingu.domain.User;
import com.mikxingu.dto.UserDTO;
import com.mikxingu.repositores.UserRepository;
import com.mikxingu.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
		
	}
	
	public User findById(String id) {
		
		Optional<User> user = userRepository.findById(id);
		if (user == null) {
			throw new ObjectNotFoundException("Usuário não encontrado");
		}
		return user.get();
	}

	public User insert(User obj) {
		return userRepository.insert(obj);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}