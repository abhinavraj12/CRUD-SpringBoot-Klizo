package com.klizo.crud.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klizo.crud.assignment.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	public User findByUsername(String userName);
}
