package com.minimarket.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
		ResponseEntity<Cliente[]> lstClientes = rt.getForEntity(URL + "/cliente/lista", Cliente[].class);
		model.addAttribute("lstClientes", lstClientes.getBody());
		model.addAttribute("cliente", new Cliente());
		return "listCliente";
	}
	
	@RequestMapping("/crear_cli")
	public String crearCliente(Model model) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ubigeo[]> lstUbigeo = rt.getForEntity(URL + "/util/ubigeo", Ubigeo[].class);
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("lstUbigeo", lstUbigeo.getBody());
		return "newCliente";
	}
	
	
	@RequestMapping("graba_cli")
	public String grabarCliente(@ModelAttribute Cliente cliente, Model model, RedirectAttributes redirect) {
		String apiUrlRegistro = URL + "/cliente/registrar";

		// Crea una instancia de RestTemplate
		RestTemplate rt = new RestTemplate();

		try {
			Gson gson = new Gson();
			String json = gson.toJson(cliente);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);

			rt.postForObject(apiUrlRegistro, entity, String.class);

			redirect.addFlashAttribute("mensaje", "Se reigstró el cliente exitosamente");
			redirect.addFlashAttribute("clase", "alert alert-success");
		} catch (Exception e) {
			redirect.addFlashAttribute("mensaje", "Error al registrar cliente");
			redirect.addFlashAttribute("clase", "alert alert-danger");
		}
		return "redirect:/crear_cli";
	}
	
	@RequestMapping("editar_cli")
	public String buscarCliente(@ModelAttribute Cliente cliente, Model model, RedirectAttributes redirect) {
		String apiUrl = URL + "/cliente/buscar/" + cliente.getIde_cli();

		// Crea una instancia de RestTemplate
		RestTemplate rt = new RestTemplate();

		try {
			// Realiza la solicitud HTTP para buscar al usuario por su ID
			ResponseEntity<Cliente[]> clienteEncontrado = rt.exchange(apiUrl, HttpMethod.GET, null, Cliente[].class);
			ResponseEntity<Ubigeo[]> lstUbigeo = rt.getForEntity(URL + "/util/ubigeo", Ubigeo[].class);
			model.addAttribute("cliente", clienteEncontrado.getBody());
			model.addAttribute("lstUbigeo", lstUbigeo.getBody());
			return "newCliente";

		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al buscar el cliente");
			model.addAttribute("clase", "alert alert-danger");
			return "redirect:/crear_pro";
		}

	}
	@RequestMapping("eliminar_cli")
	public String eliminarCliente(@ModelAttribute Cliente cliente, Model model, RedirectAttributes redirect) {
		String apiUrl = "http://localhost:8091/cliente/eliminar/" + cliente.getIde_cli();

		// Crea una instancia de RestTemplate
		RestTemplate rt = new RestTemplate();

		try {
			// Realiza la solicitud HTTP para eliminar al usuario por su ID
			rt.exchange(apiUrl, HttpMethod.DELETE, null, Void.class);

			model.addAttribute("mensaje", "Cliente eliminado");
			model.addAttribute("clase", "text-center alert alert-success");
		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al eliminar Cliente: " + e.getMessage());
			model.addAttribute("clase", "text-center alert alert-danger");
		}
		return "redirect:/cliente";
	}

}
