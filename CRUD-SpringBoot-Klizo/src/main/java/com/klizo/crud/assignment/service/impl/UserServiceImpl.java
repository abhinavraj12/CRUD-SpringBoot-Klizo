package com.klizo.crud.assignment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klizo.crud.assignment.model.User;
import com.klizo.crud.assignment.repository.UserRepo;
import com.klizo.crud.assignment.service.UserService;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepo userRepo;


    //getting user by username
    @Override
    public User getUser(String userName) {
        return this.userRepo.findByUsername(userName);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepo.deleteById(userId);
    }


}
