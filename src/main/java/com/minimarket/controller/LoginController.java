package com.minimarket.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.minimarket.model.Usuario;

@Controller
public class LoginController {
	
	Usuario u = new Usuario();
	
	private String URL="http://localhost:8094";
	

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
	    String apiUrl = URL + "/login";
	    
	    // Crea una instancia de RestTemplate
	    RestTemplate rt = new RestTemplate();
	    
	    // Configura los encabezados de la solicitud
	    HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	    
	    // Crea un objeto HttpEntity con los datos de usuario y encabezados
	    HttpEntity<Usuario> requestEntity = new HttpEntity<>(usuario, headers);
	    
	    // Realiza la solicitud HTTP utilizando el método POST y pasando el objeto usuario
	    ResponseEntity<Usuario> usuarioEncontrado = rt.exchange(apiUrl, HttpMethod.POST, requestEntity, Usuario.class);
	    
	    // Obtiene la respuesta de la API REST
	    Usuario u = usuarioEncontrado.getBody();
	    
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
