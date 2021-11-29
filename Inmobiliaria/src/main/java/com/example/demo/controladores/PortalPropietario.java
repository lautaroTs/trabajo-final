package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.servicio.PropietarioService;

@Controller
@RequestMapping("/propietario")
public class PortalPropietario {

	@Autowired
	PropietarioService propietarioService;
	
	@GetMapping("/crear")
	public String crearPropietario(
			Model model, 
			@RequestParam String nombre, 
			@RequestParam String apellido, 
			@RequestParam String email, 
			@RequestParam String password) {
		
		
		model.addAttribute(propietarioService.CrearPropietario(null, password, apellido, apellido));
		
		return "05-propietario";
	}
	
}
