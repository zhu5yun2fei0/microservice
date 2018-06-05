package com.yunfei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yunfei.UserService.UserService;
import com.yunfei.entity.User;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		User user=this.userService.getUser(id);
		return user;
	}
}
