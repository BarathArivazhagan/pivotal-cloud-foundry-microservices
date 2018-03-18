package com.barath.school.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

	@RequestMapping("/")
	public String handleHome(){
		return "Welcome to MongoDB School Demo Application";
	}
	
	
}
