package com.klizo.crud.assignment.service;

import com.klizo.crud.assignment.model.User;

public interface UserService {

  
    //get user by username
    public User getUser(String userName);

    //delete user by id
    public void deleteUser(Long userId);
}
