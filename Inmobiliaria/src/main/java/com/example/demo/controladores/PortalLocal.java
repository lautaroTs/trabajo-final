package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.servicio.LocalService;

@Controller
@RequestMapping("/local")
public class PortalLocal {

	@Autowired
	private LocalService local;

	@GetMapping("")
	public String local() {
		return "inquilino.html";
	}

}
