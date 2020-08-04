package com.motoshop.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motoshop.spring.model.User;

@RestController
@RequestMapping(value = "/login")
public class UserController {
	@GetMapping("/")
	public String login(){
		return "authenticated successfully" ;
	}


}
