package com.example.demo.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Propiedad;
import com.example.demo.entidades.Propietario;
import com.example.demo.entidades.Usuario;
import com.example.demo.errores.ErrorServicio;
import com.example.demo.repositorio.PropiedadRepositorio;
import com.example.demo.repositorio.PropietarioRepositorio;
import com.example.demo.repositorio.UsuarioRepositorio;

@Service
public class PropietarioService {

	@Autowired
	private PropietarioRepositorio propietarioRepositorio;
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private PropiedadRepositorio propiedadRepositorio;
	
	public void CrearPropietario(Integer dni, String direccion, String idu, String idp) throws ErrorServicio{
		
		Validar(dni, direccion, idu, idp);
		
		Propietario propietario = new Propietario();
		
		Optional<Usuario> respuesta = usuarioRepositorio.findById(idu);
		
		if(respuesta.isPresent()) {
			
			Usuario usuario = respuesta.get();
			
			propietario.setNombre(usuario.getNombre());
			propietario.setApellido(usuario.getApellido());
			propietario.setContrasenia(usuario.getContrasenia());
			propietario.setEmail(usuario.getEmail());
			propietario.setId(usuario.getId());
			propietario.setNivelAcceso(3);
			
		}else {
			throw new ErrorServicio("No se encontro el propietario solicitado");
		}

		propietario.setDni(dni);
		propietario.setDireccion(direccion);
		propietario.setPropiedad(propiedadRepositorio.findById(idp).get());
		
		propietarioRepositorio.save(propietario);
	}
	
	public void Validar (Integer dni, String direccion, String idu, String idp) throws ErrorServicio{
		
		if(dni == null) {
			throw new ErrorServicio("El dni del propietario no puede ser null");
		}
		
		if(direccion == null || direccion.isEmpty()) {
			throw new ErrorServicio("La direccion del propietario no puede ser null");
		}
		
		if(idu == null || idu.isEmpty()) {
			throw new ErrorServicio("El idUsuario del propietario no puede ser null");
		}
		
		if(idp == null || idp.isEmpty()) {
			throw new ErrorServicio("El idPropiedad del propietario no puede ser null");
		}
	}
	
	public void ModificarPropietario (String id, String nombre, String apellido, String contrasenia, String email, Integer dni, String direccion, String idp) throws ErrorServicio {
		
		Optional<Propietario> respuesta = propietarioRepositorio.findById(id);
		Propiedad propiedad = propiedadRepositorio.getById(idp);
		
		if(respuesta.isPresent()) {
			
			Propietario propietario = respuesta.get();
			
			propietario.setNombre(nombre);
			propietario.setApellido(apellido);
			propietario.setEmail(email);
			propietario.setContrasenia(contrasenia);
			propietario.setDni(dni);
			propietario.setDireccion(direccion);
			propietario.setPropiedad(propiedad);
			
			propietarioRepositorio.save(propietario);
		}else {
			throw new ErrorServicio("No se encontro el propietario solicitado");
		}
	}
	
	public void EliminarPropietario(String id) throws ErrorServicio{
		Optional<Propietario> respuesta = propietarioRepositorio.findById(id);
		
		if(respuesta.isPresent()) {
			
			Propietario propietario = respuesta.get();
			
			propietarioRepositorio.delete(propietario);
			
		}else {
			throw new ErrorServicio("No se encontro el propietario solicitado");
		}
	}
}
