package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entidades.Propietario;
import com.example.demo.errores.ErrorServicio;
import com.example.demo.servicio.PropietarioService;

@Controller
@RequestMapping("/propietario")
public class PortalPropietario {

	@Autowired
	PropietarioService propietarioService;
	
	@GetMapping("/crear")
	public String crearPropietario() throws ErrorServicio {
		return "02A-registroUsuarioP";
	}
	
	@PostMapping("/crear")
	public String creaProp(ModelMap model,
			@RequestParam String nombre, 
			@RequestParam String apellido, 
			@RequestParam String email, 
			@RequestParam String contrasenia,
			@RequestParam String direccion,
			@RequestParam Integer dni) throws ErrorServicio {
		try {
			Propietario propietario = propietarioService.crearPropietarioSinUsuario(nombre, apellido, contrasenia,email, dni, direccion);
			model.put("propietario",propietario);
			return "05-propietario";
		} catch (Exception e) {
			throw new  ErrorServicio ("Error Servicio crear PostMapping");
		}
		
		
	}
	
	
	
	
}
