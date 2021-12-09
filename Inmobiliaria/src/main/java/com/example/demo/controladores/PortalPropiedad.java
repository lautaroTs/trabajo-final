package com.example.demo.controladores;

import java.util.List;

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
		return "registroPropiedad.html";
	}

//	@PostMapping("/crearPropiedad")
//	public String CrearPropiedad(ModelMap model, @RequestParam String operacion, @RequestParam String zona, @RequestParam String direccion) {
//
//		try {
//			propiedadService.crearPropiedadSimple(operacion, zona, direccion);
//			model.put("exito", "la propiedad ha sido creado exitosamente");
//		} catch (ErrorServicio e) {
//			model.put("error", "la propiedad no pudo ser creado");
//			System.out.println("Error del error");
//			return "07-registroPropiedad.html";
//		}
//
//		return "registroExitoso.html";
//
//	}

	@PostMapping("/crearPropiedad")
	public String crearPropiedad(ModelMap model, @RequestParam(required = false) String id, @RequestParam String zona,
			@RequestParam String direccion, @RequestParam Double superficie, @RequestParam Integer banios,
			@RequestParam String estacionamiento, @RequestParam Double precio, @RequestParam String tipoDePropiedad,
			@RequestParam String expensas, Integer plantas, @RequestParam String antiguedad,
			@RequestParam String operacion, @RequestParam Integer dormitorios, @RequestParam Integer ambientes,
			@RequestParam String amoblado, @RequestParam String mascotas) {

		try {
			if (id !=null) {
				propiedadService.modificarPropiedad(id, zona, direccion, superficie, banios, estacionamiento, precio,
						tipoDePropiedad, expensas, plantas, antiguedad, operacion, dormitorios, ambientes, amoblado,
						mascotas);
			} else {
				propiedadService.crearPropiedad(zona, direccion, superficie, banios, estacionamiento, precio,
						tipoDePropiedad, expensas, plantas, antiguedad, operacion, dormitorios, ambientes, amoblado,
						mascotas);
				model.put("exito", "la propiedad ha sido creado exitosamente");
			}

		} catch (ErrorServicio e) {
			model.put("error", "la propiedad no pudo ser creado");
			return "07-registroPropiedad.html";
		}

		return "registroExitoso.html";

	}

//	@GetMapping("/modificar/{id}")
//	public String modificarPropiedad(Model model, @PathVariable String id) throws ErrorServicio {
//
//		Propiedad prop = propiedadService.buscarPropiedadId(id);
//		model.addAttribute("propiedad", prop);
//		return "07-registroPropiedad.html";
//	}

	@GetMapping("/modificar/{id}")
	public String modificarPropiedad(@PathVariable("id") String id, Model model) {

		try {
			Propiedad propiedad = propiedadService.buscarPropiedadPorId(id);
			model.addAttribute("propiedad", propiedad);
			return "07-registroPropiedad";
		} catch (ErrorServicio e) {
			e.printStackTrace();
			System.out.println("hay error en modificar propiedad");
			return "08-respuestaBusqueda";
		}

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

	@GetMapping("/busqueda")
	public String buscarPorZona(Model model, @RequestParam String zona) throws ErrorServicio {
		try {

			model.addAttribute("propiedades", propiedadService.buscarPropiedadPorZona(zona));
			return "08-respuestaBusqueda";
		} catch (ErrorServicio e) {
			throw new ErrorServicio("error en el controlador de busqueda x zona");

		}

	}
	@GetMapping("/detalle")
	public String detallePropiedad() {
		return "propiedad";
	}

}
