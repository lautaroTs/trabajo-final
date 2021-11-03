package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.servicio.InquilinoService;

@Controller
@RequestMapping("/inquilino") 
public class PortalInquilino {

	@Autowired
	private InquilinoService inquilinodepto;
	
	@GetMapping("")
	public String inquilino() {
		return "inquilino.html";
}
	
}
