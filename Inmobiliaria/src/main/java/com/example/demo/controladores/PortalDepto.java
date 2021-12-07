package com.example.demo.controladores;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.errores.ErrorServicio;
import com.example.demo.servicio.DeptoService;

@Controller
@RequestMapping("/depto")
public class PortalDepto {

	@Autowired(required = true)
	private DeptoService deptoService;

	@GetMapping("/crearDepartamento")
	public String crearDepto() {
		return "crearDepto.html";
	}

	@PostMapping("/crearDepartamento")
	public String CrearDepto(@RequestParam Boolean amoblado, @RequestParam Boolean esCompartido,
			@RequestParam Integer piso, @RequestParam Boolean patio, @RequestParam Integer dormitorios,
			@RequestParam Integer ambientes, @RequestParam Boolean seguridad, @RequestParam Boolean mascotas,
			@RequestParam String idp) {

		try {
			deptoService.CrearDepartamento(amoblado, esCompartido, piso, patio, dormitorios, ambientes, seguridad,
					mascotas, idp);
		} catch (ErrorServicio e) {

			e.printStackTrace();
			return "departamento.html";
		}

		return "index";
	}

	@GetMapping("/modificarDepartamento")
	public String modificarDepartamento() {
		return "modificarDepartamento.html";
	}

	@PostMapping("/modificarDepartamento")
	public String ModificarDepartamento(@RequestParam String id, @RequestParam String zona,
			@RequestParam String direccion, @RequestParam Double superficie, @RequestParam Integer banios,
			@RequestParam Boolean estacionamiento, @RequestParam Double precio, @RequestParam Date disponibilidadInicio,
			@RequestParam Date disponibilidadFinal, @RequestParam Double expensas, @RequestParam Integer plantas,
			@RequestParam Integer antiguedad, @RequestParam String operacion, @RequestParam Boolean amoblado,
			@RequestParam Boolean esCompartido, @RequestParam Integer piso, @RequestParam Boolean patio,
			@RequestParam Integer dormitorios, @RequestParam Integer ambientes, @RequestParam Boolean seguridad,
			@RequestParam Boolean mascotas) {

		try {

			deptoService.ModificarDepartamento(id, zona, direccion, superficie, banios, estacionamiento, precio,
					disponibilidadInicio, disponibilidadFinal, expensas, plantas, antiguedad, operacion, amoblado,
					esCompartido, piso, patio, dormitorios, ambientes, seguridad, mascotas);

		} catch (ErrorServicio e) {

			e.printStackTrace();
			return "departamento.html";
		}

		return "index.html";
	}

	@GetMapping("/eliminarDepartamento")
	public String EliminarDepartamento() {
		return "eliminarDepartamento.html";
	}

	@PostMapping("/eliminarDepartamento")
	public String ElimnarCasa(@RequestParam String id) {

		try {

			deptoService.EliminarDepartamento(id);
		} catch (ErrorServicio e) {

			e.printStackTrace();
			return "departamento.html";
		}

		return "index.html";
	}

}
