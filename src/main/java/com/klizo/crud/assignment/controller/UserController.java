package com.klizo.crud.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.klizo.crud.assignment.model.User;
import com.klizo.crud.assignment.repository.UserRepo;

@Controller
public class UserController {
	 
	 @Autowired
	 private UserRepo userRepo;
	
	@GetMapping("/login")
	private String login() {
		return "login";
	}
	
	@GetMapping("/")
	private String signup() {
	     return "signup";
	}
	
	@PostMapping("/signup")
    public String register(@ModelAttribute User user) {
        System.out.println(user);
        userRepo.save(user);
        return "redirect:/login";
    }

}
