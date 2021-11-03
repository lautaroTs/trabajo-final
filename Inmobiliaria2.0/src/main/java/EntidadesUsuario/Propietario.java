package EntidadesUsuario;

import javax.persistence.Entity;

import EntidadesPropiedad.Propiedad;
import lombok.Data;

@Entity
@Data
public class Propietario extends Usuario{

	protected Integer dni;
	protected String direccion;
	protected Propiedad propiedad;
	
}
