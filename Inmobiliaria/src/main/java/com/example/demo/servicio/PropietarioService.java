package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entidades.Propietario;
import com.example.demo.entidades.Usuario;
import com.example.demo.errores.ErrorServicio;
import com.example.demo.repositorio.PropietarioRepositorio;
import com.example.demo.repositorio.UsuarioRepositorio;

@Service
public class PropietarioService {

	@Autowired
	private PropietarioRepositorio propietarioRepositorio;

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

//	@Autowired
//	private PropiedadRepositorio propiedadRepositorio;

	@Transactional
	public Propietario CrearPropietario(Integer dni, String direccion, String idu, String idp) throws ErrorServicio {

		Validar(dni, direccion, idu, idp);

		Propietario propietario = new Propietario();

		Optional<Usuario> respuesta = usuarioRepositorio.findById(idu);

		if (respuesta.isPresent()) {

			Usuario usuario = respuesta.get();

			propietario.setNombre(usuario.getNombre());
			propietario.setApellido(usuario.getApellido());
			propietario.setContrasenia(usuario.getContrasenia());
			propietario.setEmail(usuario.getEmail());
			propietario.setId(usuario.getId());
			propietario.setNivelAcceso(3);
			propietario.setDni(dni);
			propietario.setDireccion(direccion);
//			TOFIX propietario.setPropiedad(propiedadRepositorio.findById(idp).get());

			propietarioRepositorio.save(propietario);
			return propietario;

		} else {
			throw new ErrorServicio("No se encontro el propietario solicitado");
		}

	}

	public void Validar(Integer dni, String direccion, String idu, String idp) throws ErrorServicio {

		if (dni == null) {
			throw new ErrorServicio("El dni del propietario no puede ser null");
		}

		if (direccion == null || direccion.isEmpty()) {
			throw new ErrorServicio("La direccion del propietario no puede ser null");
		}

		if (idu == null || idu.isEmpty()) {
			throw new ErrorServicio("El idUsuario del propietario no puede ser null");
		}

		if (idp == null || idp.isEmpty()) {
			throw new ErrorServicio("El idPropiedad del propietario no puede ser null");
		}
	}

	@Transactional
	public void ModificarPropietario(String id, String nombre, String apellido, String contrasenia, String email,
			Integer dni, String direccion) throws ErrorServicio {
//		Propiedad propiedad = propiedadRepositorio.getById(idp);

			Propietario propietario = findById(id);

			propietario.setNombre(nombre);
			propietario.setApellido(apellido);
			propietario.setEmail(email);
			propietario.setContrasenia(contrasenia);
			propietario.setDni(dni);
			propietario.setDireccion(direccion);
//			TOFIX propietario.setPropiedad(propiedad);

			propietarioRepositorio.save(propietario);
		
	}

	public void EliminarPropietario(String id) throws ErrorServicio {
			propietarioRepositorio.delete(findById(id));
	}

	@Transactional
	public List<Propietario> listarPropietario() {
		return propietarioRepositorio.findAll();

	}

	@Transactional
	public Propietario findById(String id) throws ErrorServicio {
		Optional<Propietario> respuesta = propietarioRepositorio.findById(id);
		if (respuesta.isPresent()) {
			Propietario propietario = respuesta.get();
			return propietario;
		} else {
			throw new ErrorServicio("No se encontro el propietario solicitado");
		}
	}

	public Boolean esPropietario (Usuario usuario) throws ErrorServicio {
		Propietario propietario = new Propietario();
		propietario = findById(usuario.getId());
		if (!propietario.getId().isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
}
