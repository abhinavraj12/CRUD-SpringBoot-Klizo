package com.klizo.crud.assignment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.klizo.crud.assignment.model.User;
import com.klizo.crud.assignment.repository.UserRepo;
import com.klizo.crud.assignment.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	@Override
	public User createUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		return userRepo.save(user);
	}
	
	@Override
	public User checkUserName(String userName) {
		return userRepo.findByUserName(userName);
		
	}
}
