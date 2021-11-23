package com.example.demo.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("") 
public class PortalIndex {

	@GetMapping("")
	public String inicio() {
		return "00-index";
	}

	@GetMapping("/QuienesSomos")
	public String quienesSomos(Model model) {
		
		model.addAttribute("", model);
		return "01-quienesSomos.html";
	}
	
	@GetMapping("/RegistroUsuario")
	public String registroUsuario() {
		return "02-registroUsuario.html";
	}

	@GetMapping("/Login")
	public String login() {
		return "04-login.html";
	}
	
	@GetMapping("/Propietario")
	public String propietario() {
		return "05-propietario.html";
	}
	
	@GetMapping("/Inquilino")
	public String inquilino() {
		return "06-inquilino.html";
	}
	
	@GetMapping("/RegistroPropiedad")
	public String registroPropiedad() {
		return "07-registroPropiedad.html";
	}
	
	@GetMapping("/RespuestaBusqueda")
	public String respuestaBusqueda() {
		return "08-respuestaBusqueda.html";
	}
	
	@GetMapping("/TerminosYCondiciones")
	public String terminosYCondiciones() {
		return "09-terminosYCondiciones.html";
	}
	
	@GetMapping("/NuestrosServicios")
	public String nuestrosServicios() {
		return "10-nuestrosServicios.html";
	}
	
	@GetMapping("/RecuperoDeContraseña")
	public String recuperoDeContraseña() {
		return "11-recuperoDeContraseña.html";
	}
	
}
