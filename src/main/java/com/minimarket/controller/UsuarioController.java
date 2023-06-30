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
import com.minimarket.model.TipoDocumento;
import com.minimarket.model.TipoUsuario;
import com.minimarket.model.Usuario;

@Controller
public class UsuarioController {

	private String URL = "http://localhost:8094";

	Usuario u = new Usuario();

	@RequestMapping("/user")
	private String lista(Model model) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Usuario[]> lstUsuarios = rt.getForEntity(URL + "/usuario/lista", Usuario[].class);
		model.addAttribute("lstUsuarios", lstUsuarios.getBody());
		model.addAttribute("usuario", new Usuario());
		return "listUser";
	}

	@RequestMapping("/crear_usu")
	public String crearUsuario(Model model) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<TipoUsuario[]> lstTipoUser = rt.getForEntity(URL + "/util/tipoUsuario", TipoUsuario[].class);
		ResponseEntity<TipoDocumento[]> lstTipoDocs = rt.getForEntity(URL + "/util/tipoDocumento",
				TipoDocumento[].class);
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("tipocla", "password");
		model.addAttribute("lstTipoUser", lstTipoUser.getBody());
		model.addAttribute("lstTipoDocs", lstTipoDocs.getBody());
		return "newUser";
	}

	@RequestMapping("graba_usu")
	public String grabaUsuario(@ModelAttribute Usuario usuario, Model model, RedirectAttributes redirect) {
		String apiUrlRegistro = URL + "/usuario/registrar";

		// Crea una instancia de RestTemplate
		RestTemplate rt = new RestTemplate();

		try {
			Gson gson = new Gson();
			String json = gson.toJson(usuario);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);

			rt.postForObject(apiUrlRegistro, entity, String.class);

			redirect.addFlashAttribute("mensaje", "Se reigstró al usuario exitosamente");
			redirect.addFlashAttribute("clase", "alert alert-success");
		} catch (Exception e) {
			redirect.addFlashAttribute("mensaje", "Error al registrar usuario");
			redirect.addFlashAttribute("clase", "alert alert-danger");
		}
		return "redirect:/crear_usu";
	}

	@RequestMapping("editar_usu")
	public String buscarUsuario(@ModelAttribute Usuario u, Model model, RedirectAttributes redirect) {
		String apiUrl = URL + "/usuario/buscar/" + u.getIde_usu();

		// Crea una instancia de RestTemplate
		RestTemplate rt = new RestTemplate();

		try {
			// Realiza la solicitud HTTP para buscar al usuario por su ID
			ResponseEntity<Usuario> usuarioEncontrado = rt.exchange(apiUrl, HttpMethod.GET, null, Usuario.class);
			ResponseEntity<TipoUsuario[]> lstTipoUser = rt.getForEntity(URL + "/util/tipoUsuario",
					TipoUsuario[].class);
			ResponseEntity<TipoDocumento[]> lstTipoDocs = rt.getForEntity(URL + "/util/tipoDocumento",
					TipoDocumento[].class);

			model.addAttribute("usuario", usuarioEncontrado.getBody());
			model.addAttribute("tipocla", "text");
			model.addAttribute("lstTipoUser", lstTipoUser.getBody());
			model.addAttribute("lstTipoDocs", lstTipoDocs.getBody());
			return "newUser";

		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al buscar el usuario");
			model.addAttribute("clase", "alert alert-danger");
			return "redirect:/crear_usu";
		}

	}

	@RequestMapping("eliminar_usu")
	public String eliminarUsuario(@ModelAttribute Usuario u, Model model, RedirectAttributes redirect) {
		String apiUrl = "http://localhost:8091/usuario/eliminar/" + u.getIde_usu();

		// Crea una instancia de RestTemplate
		RestTemplate rt = new RestTemplate();

		try {
			// Realiza la solicitud HTTP para eliminar al usuario por su ID
			rt.exchange(apiUrl, HttpMethod.DELETE, null, Void.class);

			model.addAttribute("mensaje", "Usuario eliminado");
			model.addAttribute("clase", "text-center alert alert-success");
		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al eliminar usuario: " + e.getMessage());
			model.addAttribute("clase", "text-center alert alert-danger");
		}
		return "redirect:/user";
	}
}
