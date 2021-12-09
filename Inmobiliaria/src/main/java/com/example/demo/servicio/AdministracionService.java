package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entidades.Administracion;
import com.example.demo.entidades.Usuario;
import com.example.demo.errores.ErrorServicio;
import com.example.demo.repositorio.AdministracionRepositorio;
import com.example.demo.repositorio.UsuarioRepositorio;

@Service
public class AdministracionService {

	@Autowired
	private AdministracionRepositorio administracionRepositorio;

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private UsuarioService usuarioService;

	// Crear usuario administracion teniendo ya el usuario creado
//	@Transactional
//	public Administracion CrearAdministracion(String direccion, String id) throws ErrorServicio {
//
//		Validar(direccion, id);
//
//		Administracion administracion = new Administracion();
//
//		Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
//
//		if (respuesta.isPresent()) {
//
//			Usuario usuario = respuesta.get();
//
//			administracion.setNombre(usuario.getNombre());
//			administracion.setApellido(usuario.getApellido());
//			administracion.setContrasenia(usuario.getContrasenia());
//			administracion.setEmail(usuario.getEmail());
//			administracion.setId(usuario.getId());
//
//			administracion.setDireccion(direccion);
//			administracionRepositorio.save(administracion);
//
//			return administracion;//Hay en este método una devolución administración 
//		} else {
//			throw new ErrorServicio("No se encontro el usuario solicitado.");
//		}
//
//	}

//	@Transactional
//	public Administracion CrearUsuarioAdministracion(String nombre, String apellido, String email, String contrasenia,
//			String direccion) throws ErrorServicio {
//		try {
//			Usuario usuario = usuarioService.CrearUsuario(nombre, apellido, email, contrasenia);
//			Administracion administracion = new Administracion();
//			
//			administracion.setNombre(usuario.getNombre());
//			administracion.setApellido(usuario.getApellido());
//			administracion.setContrasenia(usuario.getContrasenia());
//			administracion.setEmail(usuario.getEmail());
//			administracion.setId(usuario.getId());
//			administracion.setDireccion(direccion);
//			
//			administracionRepositorio.save(administracion);
//			
//			return administracion;	// En este método hay otro retono de administración 		
//		} catch (Exception e) {
//			throw new ErrorServicio("No se pudo crear el usuario administracion.");
//		}
//	}

	public void Validar(String direccion, String id) throws ErrorServicio {

		if (direccion == null || direccion.isEmpty()) {
			throw new ErrorServicio("La direccion de la administracion no puede ser null");
		}

		if (id == null || id.isEmpty()) {
			throw new ErrorServicio("El idUsuario de la administracion no puede ser null");
		}
	}

	public void Validar(String direccion, String idu, String idp) throws ErrorServicio {

		if (direccion == null || direccion.isEmpty()) {
			throw new ErrorServicio("La direccion de la administracion no puede ser null");
		}

		if (idu == null || idu.isEmpty()) {
			throw new ErrorServicio("El idUsuario de la administracion no puede ser null");
		}

		if (idp == null || idp.isEmpty()) {
			throw new ErrorServicio("El idPropiedad de la administracion no puede ser null");
		}
	}

	@Transactional
	public void ModificarAdministracion(String id, String nombre, String apellido, String contrasenia, String email,
			String direccion) throws ErrorServicio {

		Optional<Administracion> respuesta = administracionRepositorio.findById(id);

		if (respuesta.isPresent()) {

			Administracion administracion = respuesta.get();

			administracion.setNombre(nombre);
			administracion.setApellido(apellido);
			administracion.setEmail(email);
			administracion.setContrasenia(contrasenia);
			administracion.setDireccion(direccion);

			administracionRepositorio.save(administracion);
		} else {
			throw new ErrorServicio("No se encontro el usuario administracion solicitado");
		}
	}

	public void EliminarAdministracion(String id) throws ErrorServicio {
		Optional<Administracion> respuesta = administracionRepositorio.findById(id);

		if (respuesta.isPresent()) {

			Administracion administracion = respuesta.get();

			administracionRepositorio.delete(administracion);

		} else {
			throw new ErrorServicio("No se encontro la administracion solicitada");
		}
	}

	@Transactional
	public List<Administracion> listarAdministracion() {
		return administracionRepositorio.findAll();

	}

}
