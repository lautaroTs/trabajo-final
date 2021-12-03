package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entidades.Inquilino;
import com.example.demo.errores.ErrorServicio;
import com.example.demo.servicio.InquilinoService;

@Controller
@RequestMapping("/inquilino")
public class PortalInquilino {

	@Autowired
	private InquilinoService inquilinoService;

	@GetMapping("")
	public String inquilino() {
		return "inquilino.html";
	}

	@GetMapping("/encontrar")
	public String listaInquilinos(ModelMap model, @RequestParam String id) throws ErrorServicio {
		Inquilino inquilino = inquilinoService.findById(id);
		model.addAttribute("inquilino", inquilino.getApellido() + " " + inquilino.getNombre());
		return "inquilino";
	}

}
