package com.klizo.crud.assignment.service;


import com.klizo.crud.assignment.model.User;

public interface UserService {
	public User createUser(User user);
	public User checkUserName(String userName);
}
