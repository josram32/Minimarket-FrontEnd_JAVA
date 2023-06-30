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
import com.minimarket.model.Cargo;
import com.minimarket.model.Proveedor;
import com.minimarket.model.Ubigeo;

@Controller
public class ProveedorController {
	private String URL = "http://localhost:8094";

	Proveedor v = new Proveedor();

	@RequestMapping("/proveedor")
	private String lista(Model model) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Proveedor[]> lstProveedores = rt.getForEntity(URL + "/proveedor/lista", Proveedor[].class);
		model.addAttribute("lstProveedores", lstProveedores.getBody());
		model.addAttribute("proveedor", new Proveedor());
		return "listProveedor";
	}

	@RequestMapping("/crear_prv")
	public String crearProveedor(Model model) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Cargo[]> lstCargo = rt.getForEntity(URL + "/util/cargo", Cargo[].class);
		ResponseEntity<Ubigeo[]> lstUbigeo = rt.getForEntity(URL + "/util/ubigeo",Ubigeo[].class);
		model.addAttribute("proveedor", new Proveedor());
		model.addAttribute("lstCargo", lstCargo.getBody());
		model.addAttribute("lstUbigeo", lstUbigeo.getBody());
		return "newProveedor";
	}

	@RequestMapping("graba_prv")
	public String grabarProveedor(@ModelAttribute Proveedor proveedor, Model model, RedirectAttributes redirect) {
		String apiUrlRegistro = URL + "/proveedor/registrar";

		// Crea una instancia de RestTemplate
		RestTemplate rt = new RestTemplate();

		try {
			Gson gson = new Gson();
			String json = gson.toJson(proveedor);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);

			rt.postForObject(apiUrlRegistro, entity, String.class);

			redirect.addFlashAttribute("mensaje", "Se reigstró el proveedor exitosamente");
			redirect.addFlashAttribute("clase", "alert alert-success");
		} catch (Exception e) {
			redirect.addFlashAttribute("mensaje", "Error al registrar el proveedor");
			redirect.addFlashAttribute("clase", "alert alert-danger");
		}
		return "redirect:/crear_prv";
	}

	@RequestMapping("editar_prv")
	public String buscarProveedor(@ModelAttribute Proveedor proveedor, Model model, RedirectAttributes redirect) {
		String apiUrl = URL + "/proveedor/buscar/" + proveedor.getIde_prv();

		// Crea una instancia de RestTemplate
		RestTemplate rt = new RestTemplate();

		try {
			// Realiza la solicitud HTTP para buscar al usuario por su ID
			ResponseEntity<Proveedor> proveedorEncontrado = rt.exchange(apiUrl, HttpMethod.GET, null, Proveedor.class);
			ResponseEntity<Cargo[]> lstCargo = rt.getForEntity(URL + "/util/cargo", Cargo[].class);
			ResponseEntity<Ubigeo[]> lstUbigeo = rt.getForEntity(URL + "/util/ubigeo",Ubigeo[].class);
			// Obtiene la respuesta de la API REST

			model.addAttribute("proveedor", proveedorEncontrado.getBody());
			model.addAttribute("lstCargo", lstCargo.getBody());
			model.addAttribute("lstUbigeo", lstUbigeo.getBody());
			return "newProveedor";

		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al buscar el proveedor");
			model.addAttribute("clase", "alert alert-danger");
			return "redirect:/crear_prv";
		}

	}

	@RequestMapping("eliminar_prv")
	public String eliminarProveedor(@ModelAttribute Proveedor proveedor, Model model, RedirectAttributes redirect) {
		String apiUrl = "http://localhost:8091/proveedor/eliminar/" + proveedor.getIde_prv();

		// Crea una instancia de RestTemplate
		RestTemplate rt = new RestTemplate();

		try {
			// Realiza la solicitud HTTP para eliminar al usuario por su ID
			rt.exchange(apiUrl, HttpMethod.DELETE, null, Void.class);

			model.addAttribute("mensaje", "Proveedor eliminado");
			model.addAttribute("clase", "text-center alert alert-success");
		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al eliminar el proveedor: " + e.getMessage());
			model.addAttribute("clase", "text-center alert alert-danger");
		}
		return "redirect:/proveedor";
	}
}

