package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

<<<<<<< HEAD
=======
import com.example.demo.entidades.Propietario;
>>>>>>> 59e444b8666d40083319832b132d052032b67ae2
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
	public String creaProp(Model model,
			@RequestParam String nombre, 
			@RequestParam String apellido, 
			@RequestParam String email, 
<<<<<<< HEAD
			@RequestParam String password,
			@RequestParam Integer dni) throws ErrorServicio {
		
		
		model.addAttribute(propietarioService.crearPropietarioSinUsuario(nombre, apellido, apellido, email, dni, password));
		
=======
			@RequestParam String contrasenia,
			@RequestParam String direccion,
			@RequestParam Integer dni) throws ErrorServicio {
		Propietario propietario = propietarioService.crearPropietarioSinUsuario(nombre, apellido, contrasenia,email, dni, direccion);
		model.addAttribute("propietario",propietario);
>>>>>>> 59e444b8666d40083319832b132d052032b67ae2
		return "05-propietario";
	}
	
	
	
	
}
