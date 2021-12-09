package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.errores.ErrorServicio;
import com.example.demo.servicio.UsuarioService;

@Controller
@RequestMapping("/")
public class PortalIndex {

	@Autowired
	UsuarioService usuarioService;

	@GetMapping("/")
	public String inicio() {
		return "00-index";
	}

	@GetMapping("/quienesSomos")
	public String quienesSomos() {
		return "01-quienesSomos.html";
	}

	@GetMapping("/nuestrosServicios")
	public String nuestrosServicios() {
		return "10-nuestrosServicios.html";
	}

	@GetMapping("/recuperoContrasena")
	public String recuperoDeContraseña() {
		return "11-recuperoDeContraseña.html";
	}

	@GetMapping("/login")
	public String loginForm(@RequestParam(required = false) String error, @RequestParam(required = false) String logout, ModelMap model) throws ErrorServicio {

		if (error != null) {
            model.put("error", "Usuario o clave incorrectos");
        }
        if (logout != null) {
            model.put("logout", "Ha salido correctamente.");
        }
		
		return "04-login";

	}


	@GetMapping("/registroPropiedad")
	public String registroPropiedad() {
		return "07-registroPropiedad.html";
	}

	@GetMapping("/RespuestaBusqueda")
	public String respuestaBusqueda() {
		return "08-respuestaBusqueda.html";
	}

	@GetMapping("/TerminosYCondiciones")
	public String terminosYCondiciones() {
		return "09-terminosYCondiciones.html";
	}

}
