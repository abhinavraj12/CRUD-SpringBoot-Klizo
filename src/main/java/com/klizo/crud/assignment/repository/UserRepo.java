package com.klizo.crud.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klizo.crud.assignment.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
