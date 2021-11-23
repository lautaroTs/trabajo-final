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
	public String quienesSomos() {
		return "01-quienesSomos.html";
	}

}
