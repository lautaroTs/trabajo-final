package com.example.demo.entidades;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Propietario extends Usuario{

	protected Integer dni;
	protected String direccion;
	protected Propiedad propiedad;
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
