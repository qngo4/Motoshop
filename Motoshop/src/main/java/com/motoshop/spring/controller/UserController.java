package com.motoshop.spring.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.motoshop.spring.model.UserModel;

@RestController
@RequestMapping(value = "/login")
public class UserController {
	
	@GetMapping("/")
	public String login(){
		return "authenticated successfully" ;
	}

	@RequestMapping(value = "/{userName}", method = RequestMethod.POST)
	public HttpEntity<UserModel> signin(@PathVariable("userName") String userName,
			@RequestBody UserModel userModel) {
		userModel.setPassword("Ta la supper man");
		return new ResponseEntity<UserModel>(userModel, HttpStatus.OK);
	}
	
}
