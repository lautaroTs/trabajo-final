package EntidadesPropiedad;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Depto extends Propiedad {

	protected Boolean amoblado;
	protected Boolean espCompartidos;
	protected Integer piso;
	protected Boolean patio;
	protected Integer domritorios;
	protected Integer ambientes;
	protected Boolean seguridad;
	protected Boolean mascotas;
	

	
}
