package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.GrantedAuthority;
import java.util.ArrayList;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.userdetails.User;

import com.example.demo.entidades.Usuario;
import com.example.demo.errores.ErrorServicio;
import com.example.demo.repositorio.UsuarioRepositorio;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Transactional
	public Usuario crearUsuario(String nombre, String apellido, String email, String contrasenia) throws ErrorServicio {

		Validar(nombre, apellido, email, contrasenia);

		Usuario usuario = new Usuario();

		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setEmail(email);
		String encriptada = new BCryptPasswordEncoder().encode(contrasenia);
		usuario.setContrasenia(encriptada);

		usuarioRepositorio.save(usuario);

		return usuario;
	}

	@Transactional
	public void Validar(String nombre, String apellido, String email, String contrasenia) throws ErrorServicio {

		if (nombre == null || nombre.isEmpty()) {
			throw new ErrorServicio("El nombre del usuario no puede ser null");
		}

		if (apellido == null || apellido.isEmpty()) {
			throw new ErrorServicio("El apellido del usuario no puede ser null");
		}

		if (email == null || email.isEmpty()) {
			throw new ErrorServicio("El email del usuario no puede ser null");
		}

		if (contrasenia == null || contrasenia.isEmpty()) {
			throw new ErrorServicio("La contraseña del usuario no puede ser null");
		}

	}

	@Transactional
	public void modificarUsuario(String id, String nombre, String apellido, String email, String contrasenia)
			throws ErrorServicio {

		Validar(nombre, apellido, email, contrasenia);

		Optional<Usuario> respuesta = usuarioRepositorio.findById(id);

		if (respuesta.isPresent()) {

			Usuario usuario = respuesta.get();

			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setEmail(email);
			String encriptada = new BCryptPasswordEncoder().encode(contrasenia);
			usuario.setContrasenia(encriptada);

			usuarioRepositorio.save(usuario);

		} else {
			throw new ErrorServicio("No se encontro el usuario solicitado");
		}
	}

	public void EliminarUsuario(String id) throws ErrorServicio {
		Optional<Usuario> respuesta = usuarioRepositorio.findById(id);

		if (respuesta.isPresent()) {

			Usuario usuario = respuesta.get();

			usuarioRepositorio.delete(usuario);

		} else {
			throw new ErrorServicio("No se encontro el usuario solicitado");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	
        Usuario usuario = usuarioRepositorio.buscarPorEmail(email);
        
        if (usuario != null) {
        	
            List<GrantedAuthority> permisos = new ArrayList<>();
                        
            //Creo una lista de permisos! 
            GrantedAuthority p1 = new SimpleGrantedAuthority("ROLE_"+ usuario.getRol());
            permisos.add(p1);
         
            //Esto me permite guardar el OBJETO USUARIO LOGUEADO, para luego ser utilizado
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            
            session.setAttribute("usuariosession", usuario); // llave + valor

            User user = new User(usuario.getEmail(), usuario.getContrasenia(), permisos);
            
    
            
            return user;

        } else {
            return null;
        }
	}

	@Transactional
	public List<Usuario> listarUsuario() {
		return usuarioRepositorio.findAll();

	}

	@Transactional
	public Usuario findUserByEmail(String email, String contrasenia) throws ErrorServicio {
		Usuario usuario = usuarioRepositorio.buscarPorEmail(email);
		if (usuario != null) {
			return validarUsuario(usuario, contrasenia);
		} else {
			throw new ErrorServicio("No existe el usuario.");
		}
	}

	private Usuario validarUsuario(Usuario usuario, String contrasenia) throws ErrorServicio {
		if (usuario.getContrasenia().equals(contrasenia)) {
			return usuario;
		} else {
			throw new ErrorServicio("Contraseña incorrecta");
		}
	}

	public Boolean esPropietario(Usuario usuario) throws ErrorServicio {
		PropietarioService propietarioService = new PropietarioService();
		if (propietarioService.esPropietario(usuario)) {
			return true;
		}
		return false;
	}

	public Boolean esInquilino(Usuario usuario) throws ErrorServicio {
		InquilinoService inquilinoService = new InquilinoService();
		if (inquilinoService.esInquilino(usuario)) {
			return true;
		}
		return false;
	}

	@Transactional
	public Usuario findById(String id) throws ErrorServicio {
		Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
		if (respuesta.isPresent()) {
			Usuario usuario = respuesta.get();
			return usuario;
		} else {
			throw new ErrorServicio("No se encontro el propietario solicitado");
		}
	}
}
