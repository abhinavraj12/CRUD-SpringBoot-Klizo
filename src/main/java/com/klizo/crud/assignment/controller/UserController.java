package com.klizo.crud.assignment.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.klizo.crud.assignment.model.User;
import com.klizo.crud.assignment.service.impl.UserServiceImpl;

@Controller
public class UserController {
	 
	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/")
	public String signup() {
		return "signup";
	}

	@GetMapping("/signin")
	private String login() {
		return "login";
	}


	@PostMapping("/createUser")
	public String createUser(@ModelAttribute User user, HttpSession session) {

		User userName = userService.checkUserName(user.getUserName());
		if (userName != null) {
			session.setAttribute("message", "This userName is already exist!");
			System.out.println("This userName is already exist!");

		} else {
			User userObj = userService.createUser(user);
			if (userObj != null) {
				session.setAttribute("message", "Register Successfully!");
				System.out.println("Register Successfully!");
			} else {
				session.setAttribute("message", "Something went wrong!");
				System.out.println("Something went wrong!");
			}
		}
		return "redirect:/signin";
	}
}
