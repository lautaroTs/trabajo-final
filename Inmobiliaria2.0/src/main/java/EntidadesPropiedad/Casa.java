package EntidadesPropiedad;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Casa extends Propiedad{

	protected Integer domritorios;
	protected Integer ambientes;
	protected Boolean amoblado;
	protected Boolean jardin;
	protected Boolean mascotas;
	
}
