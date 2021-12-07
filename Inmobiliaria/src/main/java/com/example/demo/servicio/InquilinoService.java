package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entidades.Inquilino;
import com.example.demo.entidades.Usuario;
import com.example.demo.errores.ErrorServicio;
import com.example.demo.repositorio.InquilinoRepositorio;
import com.example.demo.repositorio.PropiedadRepositorio;
import com.example.demo.repositorio.UsuarioRepositorio;

@Service
public class InquilinoService {

	@Autowired
	private InquilinoRepositorio inquilinoRepositorio;

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private PropiedadRepositorio propiedadRepositorio;

	@Transactional
	public Inquilino CrearInquilino(Integer dni, String idu, String idp) throws ErrorServicio {

		Inquilino inquilino = new Inquilino();

		Optional<Usuario> respuesta = usuarioRepositorio.findById(idu);

		if (respuesta.isPresent()) {

			Usuario usuario = respuesta.get();

			inquilino.setNombre(usuario.getNombre());
			inquilino.setApellido(usuario.getApellido());
			inquilino.setContrasenia(usuario.getContrasenia());
			inquilino.setEmail(usuario.getEmail());
			inquilino.setId(usuario.getId());
			inquilino.setDni(dni);
			inquilino.setPropiedad(propiedadRepositorio.findById(idp).get());

			inquilinoRepositorio.save(inquilino);

			return inquilino;

		} else {
			throw new ErrorServicio("No se encontro el inquilino solicitado");
		}
	}

	public void Validar(Integer dni, String idu, String idp) throws ErrorServicio {

		if (dni == null) {
			throw new ErrorServicio("El dni del inquilino no puede ser null");
		}

		if (idu == null || idu.isEmpty()) {
			throw new ErrorServicio("El idUsuario del inquilino no puede ser null");
		}

		if (idp == null || idp.isEmpty()) {
			throw new ErrorServicio("El idPropiedad del inquilino no puede ser null");
		}
	}

	@Transactional
	public void ModificarInquilino(String id, String nombre, String apellido, String contrasenia, String email,
			Integer dni) throws ErrorServicio {

		// Propiedad propiedad = propiedadRepositorio.getById(idp);

		Inquilino inquilino = findById(id);

		inquilino.setNombre(nombre);
		inquilino.setApellido(apellido);
		inquilino.setEmail(email);
		inquilino.setContrasenia(contrasenia);
		inquilino.setDni(dni);
		// inquilino.setPropiedad(propiedad);

		inquilinoRepositorio.save(inquilino);

	}

	public void EliminarInquilino(String id) throws ErrorServicio {
		inquilinoRepositorio.delete(findById(id));
	}

	@Transactional
	public List<Inquilino> listarInqulino() {
		return inquilinoRepositorio.findAll();
	}

	@Transactional
	public Inquilino findById(String id) throws ErrorServicio {
		Optional<Inquilino> respuesta = inquilinoRepositorio.findById(id);
		if (respuesta.isPresent()) {
			Inquilino inquilino = respuesta.get();
			return inquilino;
		} else {
			throw new ErrorServicio("No se encontro el inquilino solicitado");
		}
	}

	public Boolean esInquilino(Usuario usuario) throws ErrorServicio {
		Inquilino inquilino = new Inquilino();
		inquilino = findById(usuario.getId());
		if (!inquilino.getId().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
