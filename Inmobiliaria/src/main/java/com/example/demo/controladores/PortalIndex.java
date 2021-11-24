package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entidades.Usuario;
import com.example.demo.errores.ErrorServicio;
import com.example.demo.servicio.UsuarioService;

@Controller
@RequestMapping("") 
public class PortalIndex {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("")
	public String inicio() {
		return "00-index";
	}

	@GetMapping("/QuienesSomos")
	public String quienesSomos() { 
		return "01-quienesSomos.html";
	}
	
	@GetMapping("/RegistroUsuario")
	public String registroUsuario() {
		return "02-registroUsuario.html";
	}

	@GetMapping("/login")
	public String login() {
		return "04-login.html";
	}
	
	@PostMapping("/login")
	public String loginForm(@RequestParam String email, @RequestParam String contrasenia ) throws ErrorServicio{
		Usuario usuario = usuarioService.findUserByEmail(email, contrasenia);
		if (usuarioService.esPropietario(usuario)) {
			return "05-propietario.html";
		} else if (usuarioService.esInquilino(usuario)) {
			return "06-inquilino.html";
		} else {
		return " ";
		}
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
