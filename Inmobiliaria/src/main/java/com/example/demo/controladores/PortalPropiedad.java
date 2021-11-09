package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.errores.ErrorServicio;
import com.example.demo.servicio.PropiedadService;



@Controller
@RequestMapping("/administracion") 
public class PortalPropiedad {

	@Autowired
	private PropiedadService propiedadService;
	
	@GetMapping("/crearPropiedad")
	public String crearPropiedad() {
		return "crearPropiedad.html";
}
	
	@PostMapping("/crearPropiedad")
	public String CrearPropiedad(@RequestParam String direccion, @RequestParam String idu, @RequestParam String idp) {
		
		try {
			propiedadService.CrearPropiedad(direccion, idu, idp);
		} catch (ErrorServicio e) {
			e.printStackTrace();
			return "propiedad.html";
		}
		
		return "index.html";
		
	}
	
	@GetMapping("/modificarPropiedad")
	public String modificarPropiedad() {
		return "modificarPropiedad.html";
	}
	
	@PostMapping("/modificarPropiedad")
	public String ModificarPropiedad(@RequestParam String id, @RequestParam String nombre, @RequestParam String apellido, @RequestParam String contrasenia, @RequestParam String email, @RequestParam String direccion, @RequestParam String idp) {
	
	try {
		propiedadService.ModificarPropiedad(id, nombre, apellido, contrasenia, email, direccion, idp);
	}catch (ErrorServicio e) {
		e.printStackTrace();
		return "propiedad.html";
	}
	
	return "index.html";
	}
	
	@GetMapping("/eliminarPropiedad")
	public String EliminarPropiedad() {
		return "eliminarPropiedad.html";
	}
	
	
	@PostMapping("/eliminarPropiedad")
	public String EliminarAdministracion(@RequestParam String id){
		
		try {
			
			propiedadService.EliminarPropiedad(id);
		} catch (ErrorServicio e) {
			
			e.printStackTrace();
			return "propiedad.html";
		}
		
		return "index.html";
	}
	
}
