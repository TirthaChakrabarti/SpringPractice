package com.gl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@ModelAttribute
	public void addCommonMessage (Model model) {
		model.addAttribute("commonHeader", "Welcome to MVC project!");
	}
	
	@GetMapping("/process")
	public String process (Model model, @RequestParam("loginName") String loginName, @RequestParam("password") String password) {
		model.addAttribute("loginName", loginName);	
		model.addAttribute("password", password);	
		return "process";		
	}
}
