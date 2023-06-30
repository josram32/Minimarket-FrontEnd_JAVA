package com.minimarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UtilsController {
	
	@GetMapping("/mision")
	public String Mision(Model model) {
		
		return "mision";
	}
	
	@GetMapping("/vision")
	public String Vision(Model model) {
		
		return "vision";
	}

}
