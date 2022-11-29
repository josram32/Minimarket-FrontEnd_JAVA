package com.minimarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.minimarket.model.Cliente;
import com.minimarket.repository.IClienteRepository;
import com.minimarket.repository.IUbigeoRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private IClienteRepository repocli;
	
	@Autowired
	private IUbigeoRepository repoubi;
	
	@GetMapping("/cliente")
	public String openListadoCliente(Model model) {
		
		model.addAttribute("lstClientes", repocli.findAll());
		return "listCliente";
	}
	
	@GetMapping("/crear_cli")
	public String openNewCliente(Model model) {
		
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("lstUbigeo", repoubi.findAll());
		return "newCliente";
	}
	
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
	
	/*
	 * @PostMapping("eliminar_cli") public String eliminarCliente(@ModelAttribute
	 * Cliente c, Model model) {
	 * 
	 * try { repocli.deleteById(c.getIde_cli()); model.addAttribute("mensaje",
	 * "Usuario eliminado"); model.addAttribute("clase",
	 * "text-center alert alert-success"); } catch (Exception e) {
	 * model.addAttribute("mensaje", "Error al eliminar usuario: " +
	 * e.getMessage()); model.addAttribute("clase",
	 * "text-center alert alert-danger"); }
	 * 
	 * model.addAttribute("lstClientes", repocli.findAll()); return "listCliente"; }
	 */
	
	@GetMapping("/eliminar_cli/{id}")
	public String eliminarCliente(Model model, @PathVariable int id) {
		repocli.deleteById(id);
		return "redirect:/listCliente";
	}

}
