package com.vinicius.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	@RequestMapping(value="/welcome")
	public String welcome(Model model) {
		
		model.addAttribute("welcome", "Welcome to Vini's page");
		model.addAttribute("message", "This is a test page. Only authorized perons can view this page");
		
		return "welcome";
	}
}
