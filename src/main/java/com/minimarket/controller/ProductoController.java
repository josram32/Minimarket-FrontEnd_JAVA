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

import com.minimarket.model.Categoria;
import com.minimarket.model.Producto;
import com.minimarket.model.Proveedor;
import com.minimarket.model.UnidadMedida;

@Controller
public class ProductoController {
	
	private String URL = "http://localhost:8091";

	Producto p = new Producto();

	@RequestMapping("/producto")
	private String lista(Model model) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Producto[]> responseProg = rt.getForEntity(URL + "/producto/lista", Producto[].class);
		model.addAttribute("lstProductos", responseProg.getBody());
		model.addAttribute("producto", new Producto());
		return "listProducto";
	}
	
	@RequestMapping("/crear_pro")
	public String openNewProducto(Model model) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Categoria[]> lstCategoria = rt.getForEntity(URL + "/util/categoria", Categoria[].class);
		ResponseEntity<Proveedor[]> lstProveedor = rt.getForEntity(URL + "/proveedor/lista",Proveedor[].class);
		ResponseEntity<UnidadMedida[]> lstUnidadMedida = rt.getForEntity(URL + "/util/unidadMedida",UnidadMedida[].class);
		model.addAttribute("producto", new Producto());
		model.addAttribute("tipocla", "password");
		model.addAttribute("lstCategorias", lstCategoria.getBody());
		model.addAttribute("lstProveedor", lstProveedor.getBody());
		model.addAttribute("lstUMedida", lstUnidadMedida.getBody());
		return "newProducto";
	}
	/*
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
			ResponseEntity<Usuario[]> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, Usuario[].class);
			ResponseEntity<TipoUsuario[]> lstTipoUser = restTemplate.getForEntity(URL + "/util/tipoUsuario",
					TipoUsuario[].class);
			ResponseEntity<TipoDocumento[]> lstTipoDocs = restTemplate.getForEntity(URL + "/util/tipoDocumento",
					TipoDocumento[].class);
			// Obtiene la respuesta de la API REST
			Usuario[] usuarioEncontrado = response.getBody();

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

	}*/

	@RequestMapping("eliminar_pro")
	public String eliminarPro(@ModelAttribute Producto p, Model model, RedirectAttributes redirect) {
		String apiUrl = "http://localhost:8091/producto/eliminar/" + p.getIde_pro();

		// Crea una instancia de RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		try {
			// Realiza la solicitud HTTP para eliminar al usuario por su ID
			restTemplate.exchange(apiUrl, HttpMethod.DELETE, null, Void.class);

			model.addAttribute("mensaje", "Producto eliminado");
			model.addAttribute("clase", "text-center alert alert-success");
		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al eliminar producto: " + e.getMessage());
			model.addAttribute("clase", "text-center alert alert-danger");
		}
		return "redirect:/producto";
	}

}
