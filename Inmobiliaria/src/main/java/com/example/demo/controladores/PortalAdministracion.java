package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.servicio.AdministracionService;



@Controller
@RequestMapping("/administracion") 
public class PortalAdministracion {

	@Autowired
	private AdministracionService servicioadministracion;
	
	@GetMapping("")
	public String administracion() {
		return "administracion.html";
}
	
}
