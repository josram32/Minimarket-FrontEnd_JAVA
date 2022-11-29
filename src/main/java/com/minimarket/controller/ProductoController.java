package com.minimarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.minimarket.model.Producto;
import com.minimarket.repository.ICargoRepository;
import com.minimarket.repository.ICategoriaRepository;
import com.minimarket.repository.IProductoRepository;
import com.minimarket.repository.IProveedorRepository;
import com.minimarket.repository.IUnidadMedidaRepository;

@Controller
public class ProductoController {
	
	@Autowired
	private IProductoRepository repopro;
	
	@Autowired
	private ICargoRepository repocar;
	
	@Autowired
	private ICategoriaRepository repocat;
	
	@Autowired
	private IProveedorRepository repoprv;
	
	@Autowired
	private IUnidadMedidaRepository repoume;
	
	@GetMapping("/producto")
	public String openListadoProducto(Model model) {
		
		model.addAttribute("lstProductos", repopro.findAll());
		return "listProducto";
	}
	
	@GetMapping("/crear_pro")
	public String openNewProducto(Model model) {
		
		model.addAttribute("producto", new Producto());
		model.addAttribute("lstCargo", repocar.findAll());
		model.addAttribute("lstCategorias", repocat.findAll());
		model.addAttribute("lstProveedor", repoprv.findAll());
		model.addAttribute("lstUMedida", repoume.findAll());
		return "newProducto";
	}
	
	@PostMapping("graba_pro")
	public String saveNewProducto(@ModelAttribute Producto producto, Model model) {
		
		try {
			repopro.save(producto);
			model.addAttribute("mensaje", "Producto registrado satisfactoriamente");
			model.addAttribute("clase", "alert alert-success");
		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al registrar producto");
			model.addAttribute("clase", "alert alert-danger");
		}
		return "newProducto";
	}
	
	@PostMapping("editar_pro")
	public String buscarProducto(@ModelAttribute Producto r, Model model) {
				
		model.addAttribute("producto", repopro.findById(r.getIde_pro()));
		model.addAttribute("lstCargo", repocar.findAll());
		model.addAttribute("lstCategorias", repocat.findAll());
		model.addAttribute("lstProveedor", repoprv.findAll());
		model.addAttribute("lstUMedida", repoume.findAll());
		return "newProducto";
	}
	
	@GetMapping("/eliminar_pro/{id}")
	public String eliminarProducto(Model model, @PathVariable int id) {
		repopro.deleteById(id);
		return "redirect:/listProducto";
	}

}
