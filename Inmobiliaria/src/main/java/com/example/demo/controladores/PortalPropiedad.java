package com.example.demo.controladores;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.errores.ErrorServicio;
import com.example.demo.servicio.PropiedadService;

@Controller
@RequestMapping("/propiedad")
public class PortalPropiedad {

	@Autowired
	private PropiedadService propiedadService;

	@GetMapping("/crearPropiedad")
	public String crearPropiedad() {
		return "crearPropiedad.html";
	}

	@PostMapping("/crearPropiedad")
	public String CrearPropiedad(@RequestParam String zona, @RequestParam String direccion,
			@RequestParam Double superficie, @RequestParam Integer banios, @RequestParam Boolean estacionamiento,
			@RequestParam Double precio, @RequestParam Date disponibilidadInicio,
			@RequestParam Date disponibilidadFinal, @RequestParam Double expensas, @RequestParam Integer plantas,
			@RequestParam Integer antiguedad, @RequestParam Boolean alquiler, @RequestParam Boolean venta,
			@RequestParam String prop) {

		try {
			propiedadService.CrearPropiedad(zona, direccion, superficie, banios, estacionamiento, precio,
					disponibilidadInicio, disponibilidadFinal, expensas, plantas, antiguedad, alquiler, venta, prop);
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
	public String ModificarPropiedad(@RequestParam String id, @RequestParam String zona, @RequestParam String direccion,
			@RequestParam Double superficie, @RequestParam Integer banios, @RequestParam Boolean estacionamiento,
			@RequestParam Double precio, @RequestParam Date disponibilidadInicio,
			@RequestParam Date disponibilidadFinal, @RequestParam Double expensas, @RequestParam Integer plantas,
			@RequestParam Integer antiguedad, @RequestParam Boolean alquiler, @RequestParam Boolean venta,
			@RequestParam String prop) {

		try {
			propiedadService.ModificarPropiedad(id, zona, direccion, superficie, banios, estacionamiento, precio,
					disponibilidadInicio, disponibilidadFinal, expensas, plantas, antiguedad, alquiler, venta, prop);
		} catch (ErrorServicio e) {
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
	public String EliminarPropiedad(@RequestParam String id) {

		try {

			propiedadService.EliminarPropiedad(id);
		} catch (ErrorServicio e) {

			e.printStackTrace();
			return "propiedad.html";
		}

		return "index.html";
	}

}
