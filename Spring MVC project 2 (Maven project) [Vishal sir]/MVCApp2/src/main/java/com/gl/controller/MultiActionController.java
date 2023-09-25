package com.gl.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MultiActionController {
	
	@RequestMapping("/hi")
	public String hi(Model model) { //creating a model
		String message = "Hi! Today's date on server: "+new Date(); //data for model
		model.addAttribute("Message", message);
		return "Hi";
	}
	
	@RequestMapping("/hello")
	public String hello(Model model) { //creating another model
		String message = "Hello! Today's date on server: "+new Date(); //data for model
		model.addAttribute("Message", message);
		return "Hello";
	}	
	
	@GetMapping("/home/{name}")
	public String pathVariable(Model model, @PathVariable String name) {
		String message = "Welcome "+name+"!";
		model.addAttribute("Message", message);
		return "Welcome";
	}
}
