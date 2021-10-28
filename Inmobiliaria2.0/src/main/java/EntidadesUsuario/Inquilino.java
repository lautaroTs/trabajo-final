package EntidadesUsuario;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import EntidadesPropiedad.Propiedad;
import lombok.Data;


@Entity
@Data
public class Inquilino extends Usuario {

	protected Integer dni;
	@OneToOne
	protected Propiedad propiedad;
	
	
}
