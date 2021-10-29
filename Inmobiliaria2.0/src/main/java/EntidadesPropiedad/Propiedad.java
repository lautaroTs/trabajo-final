package EntidadesPropiedad;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import EntidadesUsuario.Propietario;
import lombok.Data;

@Entity
@Data
public class Propiedad {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	protected String id;
	protected String zona;
	protected String direccion;
	protected Double superficie;
	protected Integer banios;
	protected Boolean estacionamiento;
	protected Double precio;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date disponibilidadInicio;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date disponibilidadFinal;
	protected Double expensas;
	protected Integer plantas;
	protected Integer antiguedad;
	protected Boolean alquiler;
	protected Boolean venta;
	@ManyToOne
	protected Propietario propietario;
	
	
	
}
