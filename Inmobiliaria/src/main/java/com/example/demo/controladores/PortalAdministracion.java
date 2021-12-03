package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.errores.ErrorServicio;
import com.example.demo.servicio.AdministracionService;



@Controller
@RequestMapping("/administracion") 
public class PortalAdministracion {

	@Autowired
	private AdministracionService administracionService;
	
	@GetMapping("/crearAdministracion")
	public String crearAdministracion() {
		return "crearAdministracion.html";
}
	
//	@PostMapping("/crearAdministracion")
//	public String CrearAdministracion(@RequestParam String direccion, @RequestParam String id) {
//		
//		try {
//			administracionService.CrearAdministracion(direccion, id);
//		} catch (ErrorServicio e) {
//			e.printStackTrace();
//			return "usuarioAdministracion.html";
//		}
//		
//		return "index.html";
//		
//	}
	
//	@GetMapping("/crearUsuarioAdministracion")
//	public String crearUsuarioAdministracion() {
//		return "crearUsuarioAdministracion.html";
//}
//	
//	@PostMapping("/crearUsuarioAdministracion")
//	public String CrearUsuarioAdministracion(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String email, @RequestParam String contrasenia,
//			@RequestParam String direccion) {
//		
//		try {
//			administracionService.CrearUsuarioAdministracion(nombre, apellido, email, contrasenia, direccion);
//		} catch (ErrorServicio e) {
//			e.printStackTrace();
//			return "usuarioAdministracion.html";
//		}
//		
//		return "index.html";
//		
//	}
	
	
	@GetMapping("/modificarAdministracion")
	public String modificarAdministracion() {
		return "modificarAdministracion.html";
	}
	
	@PostMapping("/modificarAdministracion")
	public String ModificarAdministracion(@RequestParam String id, @RequestParam String nombre, @RequestParam String apellido, @RequestParam String contrasenia, @RequestParam String email, @RequestParam String direccion) {
	
	try {
		administracionService.ModificarAdministracion(id, nombre, apellido, contrasenia, email, direccion);
	}catch (ErrorServicio e) {
		e.printStackTrace();
		return "administracion.html";
	}
	
	return "index.html";
	}
	
	@GetMapping("/eliminarAdministracion")
	public String EliminarAdministracion() {
		return "eliminarAdministracion.html";
	}
	
	
	@PostMapping("/eliminarAdministracion")
	public String EliminarAdministracion(@RequestParam String id){
		
		try {
			
			administracionService.EliminarAdministracion(id);
		} catch (ErrorServicio e) {
			
			e.printStackTrace();
			return "administracion.html";
		}
		
		return "index.html";
	}
	
}
