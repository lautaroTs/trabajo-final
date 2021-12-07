package com.example.demo.controladores;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entidades.Inquilino;
import com.example.demo.errores.ErrorServicio;
import com.example.demo.servicio.InquilinoService;

@Controller
@RequestMapping("/inquilino")
public class PortalInquilino {

	@Autowired
	InquilinoService inquilinoService;

	@GetMapping("/crear")
	public String inquilino() throws ErrorServicio {
		return "02-registroUsuarioI.html";
	}
	
	@PreAuthorize("hasRole('ROLE_INQUILINO')")
	@PostMapping("/actualizar-perfil")
	public String registrar(ModelMap model, HttpSession session, @RequestParam String id, @RequestParam String nombre,
			@RequestParam String apellido, @RequestParam String email, @RequestParam String contrasenia, @RequestParam Integer dni)
			throws ErrorServicio {

		Inquilino inquilino = null;
		try {

			Inquilino login = (Inquilino) session.getAttribute("usuariosession");
			if (login == null || !login.getId().equals(id)) {
				return "redirect:/index";
			}

			inquilino = inquilinoService.findById(id);
			inquilinoService.ModificarInquilino(id, nombre, apellido, email, contrasenia, dni);
			session.setAttribute("usuariosession", inquilino);

			return "perfil.html";

		} catch (ErrorServicio e) {

			model.addAttribute("error", e.getMessage());
			model.put("error", e.getMessage());
			return "redirect:/index";

		}
	}

	@GetMapping("/encontrar")
	public String listaInquilinos(ModelMap model, @RequestParam String id) throws ErrorServicio {
		Inquilino inquilino = inquilinoService.findById(id);
		model.addAttribute("inquilino", inquilino.getApellido() + " " + inquilino.getNombre());
		return "inquilino";
	}

}
