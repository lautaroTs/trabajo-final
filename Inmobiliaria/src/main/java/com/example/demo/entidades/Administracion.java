package com.example.demo.entidades;

import javax.persistence.Entity;

import com.example.demo.enums.Rol;

@Entity
public class Administracion extends Usuario {

	protected String direccion;

	// Constructor sin tener que asignar un propietario
	public Administracion(String direccion) {
		super();
		this.direccion = direccion;
	}

	public Administracion() {
		super();
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = Rol.ADMIN;
	}

}
