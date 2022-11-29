package com.minimarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.minimarket.model.Usuario;
import com.minimarket.repository.ITipoDocumentoRepository;
import com.minimarket.repository.ITipoUsuarioRepository;
import com.minimarket.repository.IUsuarioRepository;

@Controller
public class UserController {
	
	Usuario u = new Usuario();
	@Autowired
	private IUsuarioRepository repousu;
	
	@Autowired
	private ITipoDocumentoRepository repotdo;
	
	@Autowired
	private ITipoUsuarioRepository repotus;

	@GetMapping("/user")
	public String openListadoUser(Model model) {
		
		model.addAttribute("logueo", u.getCorreo());
		model.addAttribute("lstUsers", repousu.findAll());
		return "listUser";
	}
	
	@GetMapping("/crear_usu")
	public String openNewUser(Model model) {
		
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("tipocla", "password");
		model.addAttribute("lstTipoUser", repotus.findAll());
		model.addAttribute("lstTipoDocs", repotdo.findAll());
		return "newUser";
	}
	
	@PostMapping("graba_usu")
	public String saveNewUser(@ModelAttribute Usuario usuario, Model model) {
		
		try {
			repousu.save(usuario);
			model.addAttribute("mensaje", "Usuario registrado satisfactoriamente");
			model.addAttribute("clase", "alert alert-success");
		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al registrar usuario");
			model.addAttribute("clase", "alert alert-danger");
		}
		model.addAttribute("lstTipoUser", repotus.findAll());
		model.addAttribute("lstTipoDocs", repotdo.findAll());
		return "newUser";
	}
	
	@PostMapping("editar_usu")
	public String buscarUser(@ModelAttribute Usuario u, Model model) {
		
		
		model.addAttribute("usuario", repousu.findById(u.getIde_usu()));
		model.addAttribute("tipocla", "text");
		model.addAttribute("lstTipoUser", repotus.findAll());
		model.addAttribute("lstTipoDocs", repotdo.findAll());
		return "newUser";
	}
	
	/*
	 * @PostMapping("eliminar_usu") public String eliminarUser(@ModelAttribute
	 * Usuario u, Model model) {
	 * 
	 * try { repousu.deleteById(u.getIde_usu()); model.addAttribute("mensaje",
	 * "Usuario eliminado"); model.addAttribute("clase",
	 * "text-center alert alert-success"); } catch (Exception e) {
	 * model.addAttribute("mensaje", "Error al eliminar usuario: " +
	 * e.getMessage()); model.addAttribute("clase",
	 * "text-center alert alert-danger"); }
	 * 
	 * model.addAttribute("lstUsers", repousu.findAll()); return "listUser"; }
	 */
	
	@GetMapping("/eliminar_usu/{id}")
	public String eliminarUser(Model model, @PathVariable int id) {
		repousu.deleteById(id);
		return "redirect:/listUser";
	}
	
}
