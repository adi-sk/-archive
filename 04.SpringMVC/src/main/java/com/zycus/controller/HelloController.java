package com.zycus.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello.php")
	public String hello(Map model) {
		model.put("message", "Welcome to Spring MVC"); //model
		return "hello.jsp"; //view
	}
	
}
