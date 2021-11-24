package com.example.demo.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping("/login")
	public String login() {
		return "04-login.html";
	}
	
	@PostMapping("/login")
	public String loginForm(ModelMap model, @RequestParam String email, @RequestParam String contrasenia ){
		
		return "";
	}
}
