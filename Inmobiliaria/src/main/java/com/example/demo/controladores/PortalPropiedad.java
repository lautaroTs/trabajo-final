package com.example.demo.controladores;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entidades.Propiedad;
import com.example.demo.errores.ErrorServicio;
import com.example.demo.servicio.PropiedadService;

@Controller
@RequestMapping("/propiedad")
public class PortalPropiedad {

	@Autowired
	PropiedadService propiedadService;

	@GetMapping("/crearPropiedad")
	public String crearPropiedad() {
		return "crearPropiedad.html";
	}

	@PostMapping("/crearPropiedad")
	public String CrearPropiedad(ModelMap model, @RequestParam String operacion, @RequestParam String zona, @RequestParam String direccion) {

		try {
			propiedadService.crearPropiedadSimple(operacion, zona, direccion);
			model.put("exito", "la propiedad ha sido creado exitosamente");
		} catch (ErrorServicio e) {
			model.put("error", "la propiedad no pudo ser creado");
			System.out.println("Error del error");
			return "07-registroPropiedad.html";
		}

		return "registroExitoso.html";

	}
	
//	@PostMapping("/crearPropiedad")
//	public String CrearPropiedad(ModelMap model, @RequestParam String zona, @RequestParam String direccion,
//			@RequestParam Double superficie, @RequestParam Integer banios, @RequestParam Boolean estacionamiento,
//			@RequestParam Double precio, @RequestParam Date disponibilidadInicio,
//			@RequestParam Date disponibilidadFinal, @RequestParam Double expensas, @RequestParam Integer plantas,
//			@RequestParam Integer antiguedad, @RequestParam String prop, @RequestParam String operacion) {
//
//		try {
//			propiedadService.CrearPropiedad(zona, direccion, superficie, banios, estacionamiento, precio,
//					disponibilidadInicio, disponibilidadFinal, expensas, plantas, antiguedad, prop, operacion);
//			model.put("exito", "el usuario ha sido creado exitosamente");
//		} catch (ErrorServicio e) {
//			model.put("error", "el usuario no pudo ser creado");
//			return "07-registroPropiedad.html";
//		}
//
//		return "registroExitoso.html";
//
//	}

	@GetMapping("/modificar/{id}")
	public String modificarPropiedad(Model model, @PathVariable String id) throws ErrorServicio {

		Propiedad prop = propiedadService.buscarPropiedadId(id);
		model.addAttribute("propiedad", prop);
		return "07-registroPropiedad.html";
	}

	@PostMapping("/modificarPropiedad")
	public String modificarPropiedad(@RequestParam String id, @RequestParam String zona, @RequestParam String direccion,
			@RequestParam Double superficie, @RequestParam Integer banios, @RequestParam Boolean estacionamiento,
			@RequestParam Double precio, @RequestParam Date disponibilidadInicio,
			@RequestParam Date disponibilidadFinal, @RequestParam Double expensas, @RequestParam Integer plantas,
			@RequestParam Integer antiguedad, @RequestParam String prop, @RequestParam String operacion) {

		try {
			propiedadService.ModificarPropiedad(id, zona, direccion, superficie, banios, estacionamiento, precio,
					disponibilidadInicio, disponibilidadFinal, expensas, plantas, antiguedad, prop, operacion);
		} catch (ErrorServicio e) {
			e.printStackTrace();
			return "05-propietario.html";
		}

		return "index.html";
	}

	@GetMapping("/eliminar")
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

	@GetMapping("/creaP")
	public String creaPropiedades(Model model, @PathVariable String id) throws ErrorServicio {
		Propiedad propiedad = propiedadService.buscarPropiedadId(id);
		model.addAttribute("propiedad", propiedad);
		return "/05-propietario";
	}

}
