package ServiciosUsuario;

import java.util.Optional;

import org.springframework.stereotype.Service;

import EntidadesUsuario.Usuario;

@Service
public class UsuarioService {

	//@Autowired
	//private UsuarioRepositorio usuarioRepositorio;
	
	public void CrearUsuario (String nombre, String apellido, String email, String contrasenia) throws ErrorServicio{
		
		Validar(nombre, apellido, email, contrasenia);
		
		Usuario usuario = new Usuario();
		
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setEmail(email);
		usuario.setContrasenia(contrasenia);
		usuario.setNivelAcceso(1);
		usuarioRepositorio.save(usuario);
	}
	
	public void Validar (String nombre, String apellido, String email, String contrasenia) throws ErrorServicio{
		
		if(nombre == null || nombre.isEmpty()) {
			throw new ErrorServicio("El nombre del usuario no puede ser null");
		}

		if(apellido == null || apellido.isEmpty()) {
			throw new ErrorServicio("El apellido del usuario no puede ser null");
		}

		if(email == null || email.isEmpty()) {
			throw new ErrorServicio("El email del usuario no puede ser null");
		}

		if(contrasenia == null || contrasenia.isEmpty()) {
			throw new ErrorServicio("La contraseña del usuario no puede ser null");
		}
	}
	
	public void ModificarUsuario (String id, String nombre, String apellido, String email, String contrasenia) throws ErrorServicio{
		
		Validar(nombre, apellido, email, contrasenia);
		
		Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
		
		if(respuesta.isPresent()) {
			
			Usuario usuario = respuesta.get();
			
			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setEmail(email);
			usuario.setContrasenia(contrasenia);
			
			usuarioRepositorio.save(usuario);
			
		}else {
			throw new ErrorServicio("No se encontro el usuario solicitado");
		}
	}
	
	public void EliminarUsuario(String id) throws ErrorServicio{
		Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
		
		if(respuesta.isPresent()) {
			
			Usuario usuario = respuesta.get();
			
			usuarioRepositorio.deleteById(id);
			
		}else {
			throw new ErrorServicio("No se encontro el usuario solicitado");
		}
	}
	
}
