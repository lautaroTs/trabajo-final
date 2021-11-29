package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.servicio.UsuarioService;
@Controller

@RequestMapping("/usuario") 
public class PortalUsuario {

	@Autowired
	UsuarioService usuarioService;
	
	
	@GetMapping("/registroP")
	public String registroUsuario() {
		return "02A-registroUsuarioP.html";
	}
	@GetMapping("/registroI")
	public String registroUsuarioI() {
		return "02-registroUsuarioI.html";
	}
	
}
