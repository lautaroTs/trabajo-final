package com.example.demo.controladores;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.errores.ErrorServicio;
import com.example.demo.servicio.CasaService;

@Controller
@RequestMapping("/casa") 
public class PortalCasa {

	@Autowired
	private CasaService casaService;
	
	@GetMapping("/crearCasa")
	public String crearCasa() {
		return "crearCasa.html";
	}
	
	@PostMapping("/crearCasa")
	public String CrearCasa(@RequestParam Integer dormitorios,@RequestParam Integer ambientes,
			@RequestParam Boolean amoblado,@RequestParam Boolean jardin,@RequestParam Boolean mascotas,
			@RequestParam String idp){
		
		try {
			casaService.CrearCasa (dormitorios, ambientes, amoblado, jardin, mascotas, idp);
		} catch (ErrorServicio e) {
			
			e.printStackTrace();
			return "casa.html";
		}
		
		return "index.html";
	}
	
	
	@GetMapping("/modificarCasa")
	public String modificarCasa() {
		return "modificarCasa.html";
	}
	
	@PostMapping("/modificarCasa")
	public String ModificarCasa(@RequestParam String id, @RequestParam String zona, @RequestParam String direccion, @RequestParam Double superficie,
			@RequestParam Integer banios, @RequestParam Boolean estacionamiento, @RequestParam Double precio, @RequestParam Date disponibilidadInicio,
			@RequestParam Date disponibilidadFinal, @RequestParam Double expensas, @RequestParam Integer plantas, @RequestParam Integer antiguedad, 
			@RequestParam Boolean alquiler, @RequestParam Boolean venta, @RequestParam String prop ,@RequestParam Integer dormitorios,@RequestParam Integer ambientes,
			@RequestParam Boolean amoblado,@RequestParam Boolean jardin,@RequestParam Boolean mascotas, @RequestParam String idp){
		
		try {
			
			casaService.ModificarCasa (id, zona, direccion, superficie, banios, estacionamiento,
					 precio, disponibilidadInicio, disponibilidadFinal, expensas, plantas,
					 antiguedad, alquiler, venta, prop, dormitorios, ambientes, amoblado, jardin, mascotas, idp);

		} catch (ErrorServicio e) {
			
			e.printStackTrace();
			return "casa.html";
		}
		
		return "index.html";
	}
	
	@GetMapping("/eliminarCasa")
	public String EliminarCasa() {
		return "eliminarCasa.html";
	}
	
	
	@PostMapping("/eliminarCasa")
	public String ElimnarCasa(@RequestParam String id){
		
		try {
			
			casaService.EliminarCasa(id);
		} catch (ErrorServicio e) {
			
			e.printStackTrace();
			return "casa.html";
		}

		return "index.html";
	}
}
