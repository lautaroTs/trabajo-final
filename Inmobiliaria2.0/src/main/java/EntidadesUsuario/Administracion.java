package EntidadesUsuario;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Administracion extends Usuario{

	protected String direccion;
	@OneToMany
	protected Propietario propietario;
	
}
