package com.minimarket.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
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
import com.minimarket.model.TipoDocumento;
import com.minimarket.model.TipoUsuario;
import com.minimarket.model.Usuario;

@Controller
public class UsuarioController {

	private String URL = "http://localhost:8091";

	Usuario u = new Usuario();

	@RequestMapping("/user")
	private String lista(Model model) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Usuario[]> responseProg = rt.getForEntity(URL + "/usuario/lista", Usuario[].class);
		model.addAttribute("lstUsuarios", responseProg.getBody());
		model.addAttribute("usuario", new Usuario());
		return "listUser";
	}

	@RequestMapping("/crear_usu")
	public String openNewUser(Model model) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<TipoUsuario[]> responseProg = rt.getForEntity(URL + "/util/tipoUsuario", TipoUsuario[].class);
		ResponseEntity<TipoDocumento[]> responseProy = rt.getForEntity(URL + "/util/tipoDocumento",
				TipoDocumento[].class);
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("tipocla", "password");
		model.addAttribute("lstTipoUser", responseProg.getBody());
		model.addAttribute("lstTipoDocs", responseProy.getBody());
		return "newUser";
	}

	@RequestMapping("graba_usu")
	public String saveNewUser(@ModelAttribute Usuario usuario, Model model, RedirectAttributes redirect) {
		String apiUrlRegistro = URL + "/usuario/registrar";

		// Crea una instancia de RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		try {
			Gson gson = new Gson();
			String json = gson.toJson(usuario);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);

			restTemplate.postForObject(apiUrlRegistro, entity, String.class);

			redirect.addFlashAttribute("mensaje", "Se reigstró usuario exitosamente");
			redirect.addFlashAttribute("clase", "alert alert-success");
		} catch (Exception e) {
			redirect.addFlashAttribute("mensaje", "Error al registrar usuario");
			redirect.addFlashAttribute("clase", "alert alert-danger");
		}
		return "redirect:/crear_usu";
	}

	@RequestMapping("editar_usu")
	public String buscarUser(@ModelAttribute Usuario u, Model model, RedirectAttributes redirect) {
		String apiUrl = URL + "/usuario/buscar/" + u.getIde_usu();

		// Crea una instancia de RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		try {
			// Realiza la solicitud HTTP para buscar al usuario por su ID
			ResponseEntity<Usuario> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, Usuario.class);
			ResponseEntity<TipoUsuario[]> lstTipoUser = restTemplate.getForEntity(URL + "/util/tipoUsuario",
					TipoUsuario[].class);
			ResponseEntity<TipoDocumento[]> lstTipoDocs = restTemplate.getForEntity(URL + "/util/tipoDocumento",
					TipoDocumento[].class);
			// Obtiene la respuesta de la API REST
			Usuario usuarioEncontrado = response.getBody();

			model.addAttribute("usuario", usuarioEncontrado);
			model.addAttribute("tipocla", "text");
			model.addAttribute("lstTipoUser", lstTipoUser);
			model.addAttribute("lstTipoDocs", lstTipoDocs);
			return "newUser";

		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al buscar el usuario");
			model.addAttribute("clase", "alert alert-danger");
			return "redirect:/crear_usu";
		}

	}

	@RequestMapping("eliminar_usu")
	public String eliminarUser(@ModelAttribute Usuario u, Model model, RedirectAttributes redirect) {
		String apiUrl = "http://localhost:8091/usuario/eliminar/" + u.getIde_usu();

		// Crea una instancia de RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		try {
			// Realiza la solicitud HTTP para eliminar al usuario por su ID
			restTemplate.exchange(apiUrl, HttpMethod.DELETE, null, Void.class);

			model.addAttribute("mensaje", "Usuario eliminado");
			model.addAttribute("clase", "text-center alert alert-success");
		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al eliminar usuario: " + e.getMessage());
			model.addAttribute("clase", "text-center alert alert-danger");
		}
		return "redirect:/user";
	}
}
