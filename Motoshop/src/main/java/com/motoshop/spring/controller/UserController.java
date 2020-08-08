package com.motoshop.spring.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.motoshop.spring.model.UserModel;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/user")
public class UserController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public HttpEntity<UserModel> getUsers() {
		return new ResponseEntity<UserModel>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public HttpEntity<UserModel> addUsers() {
		return new ResponseEntity<UserModel>(HttpStatus.OK);
	}

	@RequestMapping(value = "/userName/{username}", method = RequestMethod.POST)
	public HttpEntity<UserModel> signin(@PathVariable("username") String userName, @RequestBody UserModel userModel) {
		userModel.setPassword("Ta la supper man");
		return new ResponseEntity<UserModel>(userModel, HttpStatus.OK);
	}

}
