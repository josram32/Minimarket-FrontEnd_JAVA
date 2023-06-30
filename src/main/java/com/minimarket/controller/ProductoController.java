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
import com.minimarket.model.Categoria;
import com.minimarket.model.Producto;
import com.minimarket.model.Proveedor;
import com.minimarket.model.UnidadMedida;

@Controller
public class ProductoController {
	
	private String URL = "http://localhost:8094";

	Producto p = new Producto();

	@RequestMapping("/producto")
	private String lista(Model model) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Producto[]> lstProductos = rt.getForEntity(URL + "/producto/lista", Producto[].class);
		model.addAttribute("lstProductos", lstProductos.getBody());
		model.addAttribute("producto", new Producto());
		return "listProducto";
	}
	
	@RequestMapping("/crear_pro")
	public String crearProducto(Model model) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Categoria[]> lstCategoria = rt.getForEntity(URL + "/util/categoria", Categoria[].class);
		ResponseEntity<Proveedor[]> lstProveedor = rt.getForEntity(URL + "/proveedor/lista",Proveedor[].class);
		ResponseEntity<UnidadMedida[]> lstUnidadMedida = rt.getForEntity(URL + "/util/unidadMedida",UnidadMedida[].class);
		model.addAttribute("producto", new Producto());
		model.addAttribute("lstCategorias", lstCategoria.getBody());
		model.addAttribute("lstProveedor", lstProveedor.getBody());
		model.addAttribute("lstUMedida", lstUnidadMedida.getBody());
		return "newProducto";
	}
	
	@RequestMapping("graba_pro")
	public String grabarProducto(@ModelAttribute Producto producto, Model model, RedirectAttributes redirect) {
		String apiUrlRegistro = URL + "/producto/registrar";

		// Crea una instancia de RestTemplate
		RestTemplate rt = new RestTemplate();

		try {
			Gson gson = new Gson();
			String json = gson.toJson(producto);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);

			rt.postForObject(apiUrlRegistro, entity, String.class);

			redirect.addFlashAttribute("mensaje", "Se reigstró el producto exitosamente");
			redirect.addFlashAttribute("clase", "alert alert-success");
		} catch (Exception e) {
			redirect.addFlashAttribute("mensaje", "Error al registrar el producto");
			redirect.addFlashAttribute("clase", "alert alert-danger");
		}
		return "redirect:/crear_pro";
	}

	@RequestMapping("editar_pro")
	public String buscarProducto(@ModelAttribute Producto producto, Model model, RedirectAttributes redirect) {
		String apiUrl = URL + "/producto/buscar/" + producto.getIde_pro();

		// Crea una instancia de RestTemplate
		RestTemplate rt = new RestTemplate();

		try {
			// Realiza la solicitud HTTP para buscar al usuario por su ID
			ResponseEntity<Producto> productoEncontrado = rt.exchange(apiUrl, HttpMethod.GET, null, Producto.class);
			ResponseEntity<Categoria[]> lstCategoria = rt.getForEntity(URL + "/util/categoria", Categoria[].class);
			ResponseEntity<Proveedor[]> lstProveedor = rt.getForEntity(URL + "/proveedor/lista",Proveedor[].class);
			ResponseEntity<UnidadMedida[]> lstUnidadMedida = rt.getForEntity(URL + "/util/unidadMedida",UnidadMedida[].class);
			
			model.addAttribute("producto", productoEncontrado.getBody());
			model.addAttribute("lstCategorias", lstCategoria.getBody());
			model.addAttribute("lstProveedor", lstProveedor.getBody());
			model.addAttribute("lstUMedida", lstUnidadMedida.getBody());
			return "newProducto";

		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al buscar el usuario");
			model.addAttribute("clase", "alert alert-danger");
			return "redirect:/crear_pro";
		}

	}

	@RequestMapping("eliminar_pro")
	public String eliminarPro(@ModelAttribute Producto p, Model model, RedirectAttributes redirect) {
		String apiUrl = "http://localhost:8091/producto/eliminar/" + p.getIde_pro();

		// Crea una instancia de RestTemplate
		RestTemplate rt = new RestTemplate();

		try {
			// Realiza la solicitud HTTP para eliminar al usuario por su ID
			rt.exchange(apiUrl, HttpMethod.DELETE, null, Void.class);

			model.addAttribute("mensaje", "Producto eliminado");
			model.addAttribute("clase", "text-center alert alert-success");
		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al eliminar producto: " + e.getMessage());
			model.addAttribute("clase", "text-center alert alert-danger");
		}
		return "redirect:/producto";
	}
	
	@RequestMapping("/catalogo")
	private String catalogo(Model model) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Producto[]> lstProductos = rt.getForEntity(URL + "/producto/lista", Producto[].class);
		model.addAttribute("lstProductos", lstProductos.getBody());
		model.addAttribute("producto", new Producto());
		return "catalogo";
	}

}
