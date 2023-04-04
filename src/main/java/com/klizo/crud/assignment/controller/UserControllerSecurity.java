package com.klizo.crud.assignment.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.klizo.crud.assignment.model.User;
import com.klizo.crud.assignment.repository.UserRepo;


@Controller
@RequestMapping("/user")
public class UserControllerSecurity {
	
	@Autowired
	private UserRepo userRepo;
	
	@ModelAttribute
	private void userDetails(Model m, Principal p) {
		String userName = p.getName();
		User user = userRepo.findByUserName(userName);
		m.addAttribute("user", user);
		
	}
	
	@GetMapping("/index")
	public String index() {
		return "user/index";
	}
	
	 
	
}
