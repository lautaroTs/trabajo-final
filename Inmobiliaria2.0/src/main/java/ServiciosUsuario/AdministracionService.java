package ServiciosUsuario;

import java.util.Optional;

import org.springframework.stereotype.Service;

import EntidadesPropiedad.Propiedad;
import EntidadesUsuario.Administracion;
import EntidadesUsuario.Propietario;
import EntidadesUsuario.Usuario;

@Service
public class AdministracionService {

	//@Autowired
	//private PropietarioRepositorio propietarioRepositorio;
		
		public void CrearAdministracion(String direccion, String idu, String idp) throws ErrorServicio{
			
			Validar(direccion, idu, idp);
			
			Administracion administracion = new Administracion();
			
			Optional<Usuario> respuesta = usuarioRepositorio.findById(idu);
			
			if(respuesta.isPresent()) {
				
				Usuario usuario = respuesta.get();
				
				administracion.setNombre(usuario.getNombre());
				administracion.setApellido(usuario.getApellido());
				administracion.setContrasenia(usuario.getContrasenia());
				administracion.setEmail(usuario.getEmail());
				administracion.setId(usuario.getId());
				administracion.setNivelAcceso(4);
				
			}else {
				throw new ErrorServicio("No se encontro la administracion solicitada");
			}

			administracion.setDireccion(direccion);
			administracion.setPropietario(propietatarioRepositorio.findById(idp).get());
			
			administracionRepositorio.save(administracion);
		}
		
		public void Validar (String direccion, String idu, String idp) throws ErrorServicio{
						
			if(direccion == null || direccion.isEmpty()) {
				throw new ErrorServicio("La direccion de la administracion no puede ser null");
			}
			
			if(idu == null || idu.isEmpty()) {
				throw new ErrorServicio("El idUsuario de la administracion no puede ser null");
			}
			
			if(idp == null || idp.isEmpty()) {
				throw new ErrorServicio("El idPropiedad de la administracion no puede ser null");
			}
		}
		
		public void ModificarAdministracion (String id, String nombre, String apellido, String contrasenia, String email, String direccion, String idp) {
			
			Optional<Administracion> respuesta = administracionRepositorio.findById(id);
			Propietario propietario = propietarioRepositorio.getById(idp);
			
			if(respuesta.isPresent()) {
				
				Administracion administracion = respuesta.get();
				
				administracion.setNombre(nombre);
				administracion.setApellido(apellido);
				administracion.setEmail(email);
				administracion.setContrasenia(contrasenia);
				administracion.setDireccion(direccion);
				administracion.setPropietario(propietario);
				
				administracionRepositorio.save(administracion);
			}else {
				throw new ErrorServicio("No se encontro la administracion solicitada");
			}
		}
		
		public void EliminarAdministracion(String id) throws ErrorServicio{
			Optional<Administracion> respuesta = administracionRepositorio.findById(id);
			
			if(respuesta.isPresent()) {
				
				Administracion administracion = respuesta.get();
				
				administracionRepositorio.deleteById(id);
				
			}else {
				throw new ErrorServicio("No se encontro la administracion solicitada");
			}
		}
}
