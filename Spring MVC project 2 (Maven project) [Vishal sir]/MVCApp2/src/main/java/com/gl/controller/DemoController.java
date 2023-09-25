package com.gl.controller;

import org.springframework.stereotype.Controller;	
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	
	@RequestMapping("/home")
	public String demo() {
		System.out.println("in the demo controller...");
		return "home";
	}
}
