package com.example.demo.entidades;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Administracion extends Usuario{

	protected String direccion;
	@OneToMany
	protected Propietario propietario;
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
}
