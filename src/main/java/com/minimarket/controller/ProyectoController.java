package com.minimarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.minimarket.model.Usuario;

@Controller
public class ProyectoController {
	
	@GetMapping("/mision") 
	public String goMision(Model model) {
		
		Usuario u = new Usuario();
	  
		model.addAttribute("usuario", new Usuario()); 
		model.addAttribute("logueo", u.getCorreo()); 
		return "mision"; 
	}
	
	@GetMapping("/vision") 
	public String goVision(Model model) {
		
		Usuario u = new Usuario();
	  
		model.addAttribute("usuario", new Usuario()); 
		model.addAttribute("logueo", u.getCorreo()); 
		return "vision"; 
	}

}
