package com.example.demo.entidades;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Inquilino extends Usuario {

	protected Integer dni;
	@OneToOne
	protected Propiedad propiedad;
	
	public Inquilino() {
		super();
	}

	public Inquilino(Integer dni, Propiedad propiedad) {
		super();
		this.dni = dni;
		this.propiedad = propiedad;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

}
