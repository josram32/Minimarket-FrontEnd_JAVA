package com.minimarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.minimarket.model.Venta;
import com.minimarket.repository.IClienteRepository;
import com.minimarket.repository.ITipoComprobanteRepository;
import com.minimarket.repository.ITipoEntregaRepository;
import com.minimarket.repository.ITipoPagoRepository;
import com.minimarket.repository.IUbigeoRepository;
import com.minimarket.repository.IUsuarioRepository;

@Controller
public class VentaController {
	
	@Autowired
	private IUsuarioRepository repousu;
	
	@Autowired
	private IClienteRepository repocli;
	
	@Autowired
	private ITipoComprobanteRepository repotco;
	
	@Autowired
	private ITipoPagoRepository repotpa;
	
	@Autowired
	private IUbigeoRepository repoubi;
	
	@Autowired
	private ITipoEntregaRepository repoten;
	
	@GetMapping("/ventas")
	public String openVenta(Model model) {
		
		model.addAttribute("venta", new Venta());
		model.addAttribute("usuarios", repousu.findAll());
		model.addAttribute("clientes", repocli.findAll());
		model.addAttribute("comprobantes", repotco.findAll());
		model.addAttribute("tipopago", repotpa.findAll());
		model.addAttribute("tipoentrega", repoten.findAll());
		model.addAttribute("ubigeo", repoubi.findAll());
		return "ventas";
	}

}
