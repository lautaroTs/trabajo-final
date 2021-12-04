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

import com.example.demo.entidades.Usuario;
import com.example.demo.errores.ErrorServicio;
import com.example.demo.servicio.UsuarioService;

@Controller

@RequestMapping("/usuario")
public class PortalUsuario {

	@Autowired
	UsuarioService usuarioService;

	@GetMapping("/registroP")
	public String registroUsuario() {
		return "02A-registroUsuarioP.html";
	}

	@GetMapping("/registroI")
	public String registroUsuarioI() {
		return "02-registroUsuarioI.html";
	}

	@PreAuthorize("hasRole('ROLE_USUARIO')")
	@PostMapping("/actualizar-perfil")
	public String registrar(ModelMap model, HttpSession session, @RequestParam String id, @RequestParam String nombre,
			@RequestParam String apellido, @RequestParam String email, @RequestParam String contrasenia)
			throws ErrorServicio {

		Usuario usuario = null;
		try {

			Usuario login = (Usuario) session.getAttribute("usuariosession");
			if (login == null || !login.getId().equals(id)) {
				return "redirect:/index";
			}

			usuario = usuarioService.findById(id);
			usuarioService.ModificarUsuario(id, nombre, apellido, email, contrasenia);
			session.setAttribute("usuariosession", usuario);

			return "perfil.html";

		} catch (ErrorServicio e) {

			model.addAttribute("error", e.getMessage());
			model.put("error", e.getMessage());
			return "redirect:/index";

		}
	}

	public String editarPerfil(HttpSession session, @RequestParam String id, ModelMap model) {

		Usuario login = (Usuario) session.getAttribute("usuariosession");
		if (login == null || !login.getId().equals(id)) {
			return "redirect:/index";
		}

		try {
			Usuario usuario = usuarioService.findById(id);
			model.addAttribute("perfil", usuario);
		} catch (ErrorServicio e) {
			model.addAttribute("error", e.getMessage());
		}
		return "perfil.html";

	}

}
