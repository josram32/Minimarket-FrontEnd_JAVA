package com.minimarket.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.minimarket.model.Cliente;
import com.minimarket.model.Ubigeo;

@Controller
public class ClienteController {
	
	private String URL = "http://localhost:8091";
	
	Cliente c = new Cliente();
	
	@RequestMapping("/cliente")
	private String lista(Model model) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Cliente[]> responseProg = rt.getForEntity(URL + "/cliente/lista", Cliente[].class);
		model.addAttribute("lstClientes", responseProg.getBody());
		model.addAttribute("cliente", new Cliente());
		return "listCliente";
	}
	
	@RequestMapping("/crear_cli")
	public String openNewCliente(Model model) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ubigeo[]> lstUbigeo = rt.getForEntity(URL + "/util/ubigeo", Ubigeo[].class);
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("lstUbigeo", lstUbigeo.getBody());
		return "newCliente";
	}
	
	
	@RequestMapping("graba_cli")
	public String saveNewUser(@ModelAttribute Cliente cliente, Model model, RedirectAttributes redirect) {
		String apiUrlRegistro = URL + "/cliente/registrar";

		// Crea una instancia de RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		try {
			Gson gson = new Gson();
			String json = gson.toJson(cliente);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);

			restTemplate.postForObject(apiUrlRegistro, entity, String.class);

			redirect.addFlashAttribute("mensaje", "Se reigstró el cliente exitosamente");
			redirect.addFlashAttribute("clase", "alert alert-success");
		} catch (Exception e) {
			redirect.addFlashAttribute("mensaje", "Error al registrar cliente");
			redirect.addFlashAttribute("clase", "alert alert-danger");
		}
		return "redirect:/crear_cli";
	}
	/*
	@PostMapping("editar_cli")
	public String buscarCliente(@ModelAttribute Cliente c, Model model) {
				
		model.addAttribute("cliente", repocli.findById(c.getIde_cli()));
		model.addAttribute("lstUbigeo", repoubi.findAll());
		return "newCliente";
	}
	
	@PostMapping("graba_cli")
	public String saveNewCliente(@ModelAttribute Cliente cliente, Model model) {
		
		try {
			repocli.save(cliente);
			model.addAttribute("mensaje", "Cliente registrado satisfactoriamente");
			model.addAttribute("clase", "alert alert-success");
		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al registrar cliente");
			model.addAttribute("clase", "alert alert-danger");
		}
		return "newCliente";
	}
	*/
	
	@RequestMapping("eliminar_cli")
	public String eliminarCliente(@ModelAttribute Cliente c, Model model, RedirectAttributes redirect) {
		String apiUrl = "http://localhost:8091/cliente/eliminar/" + c.getIde_cli();

		// Crea una instancia de RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		try {
			// Realiza la solicitud HTTP para eliminar al usuario por su ID
			restTemplate.exchange(apiUrl, HttpMethod.DELETE, null, Void.class);

			model.addAttribute("mensaje", "Cliente eliminado");
			model.addAttribute("clase", "text-center alert alert-success");
		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al eliminar Cliente: " + e.getMessage());
			model.addAttribute("clase", "text-center alert alert-danger");
		}
		return "redirect:/cliente";
	}

}
