package EntidadesUsuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class Usuario {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	protected String id;
	protected String nombre;
	protected String apellido;
	protected String email;
	protected String contrasenia;
	protected Integer nivelAcceso;
	
}
