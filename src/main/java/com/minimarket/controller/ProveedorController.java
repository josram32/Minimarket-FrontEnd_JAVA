package com.minimarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.minimarket.model.Proveedor;
import com.minimarket.repository.ICargoRepository;
import com.minimarket.repository.IProveedorRepository;

@Controller
public class ProveedorController {
	
	@Autowired
	private IProveedorRepository repoprv;
	
	@Autowired
	private ICargoRepository repocar;
	
	@GetMapping("/proveedor")
	public String openListadoProveedor(Model model) {
		
		model.addAttribute("lstProveedores", repoprv.findAll());
		return "listProveedor";
	}
	
	@GetMapping("/crear_prv")
	public String openNewProveedor(Model model) {
		
		model.addAttribute("proveedor", new Proveedor());
		model.addAttribute("lstCargo", repocar.findAll());
		return "newProveedor";
	}
	
	@PostMapping("graba_prv")
	public String saveNewProveedor(@ModelAttribute Proveedor proveedor, Model model) {
		
		try {
			repoprv.save(proveedor);
			model.addAttribute("mensaje", "Proveedor registrado satisfactoriamente");
			model.addAttribute("clase", "alert alert-success");
		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al registrar proveedor");
			model.addAttribute("clase", "alert alert-danger");
		}
		return "newProveedor";
	}
	
	@PostMapping("editar_prv")
	public String buscarProveedor(@ModelAttribute Proveedor r, Model model) {
				
		model.addAttribute("proveedor", repoprv.findById(r.getIde_prv()));
		model.addAttribute("lstCargo", repocar.findAll());
		return "newProveedor";
	}
	
	@GetMapping("/eliminar_prv/{id}")
	public String eliminarProveedor(Model model, @PathVariable int id) {
		repoprv.deleteById(id);
		return "redirect:/listProveedor";
	}

}
