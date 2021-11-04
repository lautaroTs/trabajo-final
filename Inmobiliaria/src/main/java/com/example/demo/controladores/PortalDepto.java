package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.servicio.DeptoService;

@Controller
@RequestMapping("/depto") 
public class PortalDepto {

	@Autowired
	private DeptoService serviciodepto;
	
	@GetMapping("")
	public String depto() {
		return "depto.html";
}
	
}
