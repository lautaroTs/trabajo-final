package com.example.demo.entidades;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Propietario extends Usuario {

	protected Integer dni;
	protected String direccion;
	protected Propiedad propiedad;

	@ManyToOne
	protected Administracion administracion;

	public Propietario(Integer dni, String direccion, Propiedad propiedad, Administracion administracion) {
		super();
		this.dni = dni;
		this.direccion = direccion;
		this.propiedad = propiedad;
		this.administracion = administracion;
	}

	public Propietario() {
		super();
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

}
