package com.minimarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.minimarket.model.Usuario;
import com.minimarket.repository.IUsuarioRepository;

@Controller
public class LoginController {
	
	Usuario u = new Usuario();
	
	@Autowired
	private IUsuarioRepository repousu;

	@GetMapping("/")
	public String openLogin(Model model) {
		
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	
	@GetMapping("/principal") 
	public String goPrincipal(Model model) {
	  
		model.addAttribute("usuario", new Usuario()); model.addAttribute("logueo", u.getCorreo()); 
		return "principal"; 
	} 
	
	@PostMapping("/principal")
	public String openPrincipal(Model model) {
		
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("logueo", u.getCorreo());
		return "principal";
	}
	
	@PostMapping("/validar")
	public String validarAcceso(Model model, @ModelAttribute Usuario usuario) {
		
		System.out.println(usuario);
		
		// validar usuario con los datos ingresados
		u = repousu.findByCorreoAndClave(usuario.getCorreo(), usuario.getClave());
		if (u == null) {
			model.addAttribute("mensaje", "Usuario o clave incorrecto");
			model.addAttribute("clase", "alert alert-danger");
			return "login";
		} else {
			
			model.addAttribute("logueo", u.getCorreo());
			return "principal";
		}
	}
	
}
