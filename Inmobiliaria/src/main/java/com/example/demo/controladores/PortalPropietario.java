<<<<<<< HEAD
package com.example.demo.controladores;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entidades.Propiedad;
import com.example.demo.entidades.Propietario;
import com.example.demo.enums.Rol;
import com.example.demo.errores.ErrorServicio;
import com.example.demo.servicio.PropiedadService;
import com.example.demo.servicio.PropietarioService;

@Controller
@RequestMapping("/propietario")
public class PortalPropietario {

	@Autowired
	PropietarioService propietarioService;
	
	@Autowired
	PropiedadService propiedadService;

	@GetMapping("/crear")
	public String crearPropietario() throws ErrorServicio {
		return "02A-registroUsuarioP";
	}

	@PostMapping("/crear")
	public String creaProp(ModelMap model,
			@RequestParam String nombre, @RequestParam String apellido,
			@RequestParam String email, @RequestParam String contrasenia, @RequestParam String direccion,
			@RequestParam Integer dni, Rol PROPIETARIO) throws ErrorServicio {
		try {
			propietarioService.crearPropietarioSinUsuario(nombre, apellido, contrasenia, email, dni, direccion,
					PROPIETARIO);
			model.put("exito", "el usuario ha sido creado exitosamente");
		} catch (Exception e) {
			model.put("error", "el usuario no pudo ser creado");
		}
		return "04-login";
	}

	@PreAuthorize("hasRole('ROLE_PROPIETARIO')")
	@PostMapping("/actualizar-perfil")
	public String registrar(ModelMap model, HttpSession session, @RequestParam String id, @RequestParam String nombre,
			@RequestParam String apellido, @RequestParam String email, @RequestParam String contrasenia,
			@RequestParam Integer dni, @RequestParam String direccion) throws ErrorServicio {

		Propietario propietario = null;
		try {

			Propietario login = (Propietario) session.getAttribute("usuariosession");
			if (login == null || !login.getId().equals(id)) {
				return "redirect:/index";
			}

			propietario = propietarioService.findById(id);
			propietarioService.ModificarPropietario(id, nombre, apellido, email, contrasenia, dni, direccion);
			session.setAttribute("usuariosession", propietario);

			return "perfil.html";

		} catch (ErrorServicio e) {

			model.addAttribute("error", e.getMessage());
			model.put("error", e.getMessage());
			return "redirect:/index";

		}
	}

	public String editarPerfil(HttpSession session, @RequestParam String id, ModelMap model) {

		Propietario login = (Propietario) session.getAttribute("usuariosession");
		if (login == null || !login.getId().equals(id)) {
			return "redirect:/index";
		}

		try {
			Propietario propietario = propietarioService.findById(id);
			model.addAttribute("perfil", propietario);
		} catch (ErrorServicio e) {
			model.addAttribute("error", e.getMessage());
		}
		return "perfil.html";

	}
	
	@GetMapping("/inicio")
	public String propietario(ModelMap modelo) {

		List<Propiedad> propiedad = propiedadService.listarPropiedad();

		modelo.put("propiedad", propiedad);

		return "05-propietario.html";
	}

}
=======
package com.example.demo.controladores;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entidades.Propiedad;
import com.example.demo.entidades.Propietario;
import com.example.demo.enums.Rol;
import com.example.demo.errores.ErrorServicio;
import com.example.demo.servicio.PropiedadService;
import com.example.demo.servicio.PropietarioService;

@Controller
@RequestMapping("/propietario")
public class PortalPropietario {

	@Autowired
	PropietarioService propietarioService;
	
	@Autowired
	PropiedadService propiedadService;

	@GetMapping("/crear")
	public String crearPropietario() throws ErrorServicio {
		return "02A-registroUsuarioP";
	}

	@PostMapping("/crear")
	public String creaProp(ModelMap model,
			@RequestParam String nombre, @RequestParam String apellido,
			@RequestParam String email, @RequestParam String contrasenia, @RequestParam String direccion,
			@RequestParam Integer dni, Rol PROPIETARIO) throws ErrorServicio {
		try {
			propietarioService.crearPropietarioSinUsuario(nombre, apellido, contrasenia, email, dni, direccion,
					PROPIETARIO);
			model.put("exito", "el usuario ha sido creado exitosamente");
		} catch (Exception e) {
			model.put("error", "el usuario no pudo ser creado");
		}
		return "04-login";
	}

	@PreAuthorize("hasRole('ROLE_PROPIETARIO')")
	@PostMapping("/actualizar-perfil")
	public String registrar(ModelMap model, HttpSession session, @RequestParam String id, @RequestParam String nombre,
			@RequestParam String apellido, @RequestParam String email, @RequestParam String contrasenia,
			@RequestParam Integer dni, @RequestParam String direccion) throws ErrorServicio {

		Propietario propietario = null;
		try {

			Propietario login = (Propietario) session.getAttribute("usuariosession");
			if (login == null || !login.getId().equals(id)) {
				return "redirect:/index";
			}

			propietario = propietarioService.findById(id);
			propietarioService.ModificarPropietario(id, nombre, apellido, email, contrasenia, dni, direccion);
			session.setAttribute("usuariosession", propietario);

			return "perfil.html";

		} catch (ErrorServicio e) {

			model.addAttribute("error", e.getMessage());
			model.put("error", e.getMessage());
			return "redirect:/index";

		}
	}

	public String editarPerfil(HttpSession session, @RequestParam String id, ModelMap model) {

		Propietario login = (Propietario) session.getAttribute("usuariosession");
		if (login == null || !login.getId().equals(id)) {
			return "redirect:/index";
		}

		try {
			Propietario propietario = propietarioService.findById(id);
			model.addAttribute("perfil", propietario);
		} catch (ErrorServicio e) {
			model.addAttribute("error", e.getMessage());
		}
		return "perfil.html";

	}
	
	@GetMapping("/inicio")
	public String propietario(ModelMap modelo) {

		List<Propiedad> propiedad = propiedadService.listarPropiedad();

		modelo.put("propiedad", propiedad);

		return "05-propietario.html";
	}

}
>>>>>>> 4112ebde9bbb6693ac4c29cada6339742ac972f1
