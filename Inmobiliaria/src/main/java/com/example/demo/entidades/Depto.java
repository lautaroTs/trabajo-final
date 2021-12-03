package com.example.demo.entidades;

import javax.persistence.Entity;

@Entity
public class Depto extends Propiedad {

	protected Boolean amoblado;
	protected Boolean espCompartidos;
	protected Integer piso;
	protected Boolean patio;
	protected Integer dormitorios;
	protected Integer ambientes;
	protected Boolean seguridad;
	protected Boolean mascotas;

	public Depto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Depto(Boolean amoblado, Boolean espCompartidos, Integer piso, Boolean patio, Integer dormitorios,
			Integer ambientes, Boolean seguridad, Boolean mascotas) {
		super();
		this.amoblado = amoblado;
		this.espCompartidos = espCompartidos;
		this.piso = piso;
		this.patio = patio;
		this.dormitorios = dormitorios;
		this.ambientes = ambientes;
		this.seguridad = seguridad;
		this.mascotas = mascotas;
	}

	public Boolean getAmoblado() {
		return amoblado;
	}

	public void setAmoblado(Boolean amoblado) {
		this.amoblado = amoblado;
	}

	public Boolean getEspCompartidos() {
		return espCompartidos;
	}

	public void setEspCompartidos(Boolean espCompartidos) {
		this.espCompartidos = espCompartidos;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public Boolean getPatio() {
		return patio;
	}

	public void setPatio(Boolean patio) {
		this.patio = patio;
	}

	public Integer getDormitorios() {
		return dormitorios;
	}

	public void setDormitorios(Integer dormitorios) {
		this.dormitorios = dormitorios;
	}

	public Integer getAmbientes() {
		return ambientes;
	}

	public void setAmbientes(Integer ambientes) {
		this.ambientes = ambientes;
	}

	public Boolean getSeguridad() {
		return seguridad;
	}

	public void setSeguridad(Boolean seguridad) {
		this.seguridad = seguridad;
	}

	public Boolean getMascotas() {
		return mascotas;
	}

	public void setMascotas(Boolean mascotas) {
		this.mascotas = mascotas;
	}

}
