package com.example.demo.entidades;

import javax.persistence.Entity;

@Entity
public class Casa extends Propiedad {

	protected Integer domritorios;
	protected Integer ambientes;
	protected Boolean amoblado;
	protected Boolean jardin;
	protected Boolean mascotas;
	

	public Casa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Casa(Integer domritorios, Integer ambientes, Boolean amoblado, Boolean jardin, Boolean mascotas) {
		super();
		this.domritorios = domritorios;
		this.ambientes = ambientes;
		this.amoblado = amoblado;
		this.jardin = jardin;
		this.mascotas = mascotas;
	}

	public Integer getDomritorios() {
		return domritorios;
	}

	public void setDomritorios(Integer domritorios) {
		this.domritorios = domritorios;
	}

	public Integer getAmbientes() {
		return ambientes;
	}

	public void setAmbientes(Integer ambientes) {
		this.ambientes = ambientes;
	}

	public Boolean getAmoblado() {
		return amoblado;
	}

	public void setAmoblado(Boolean amoblado) {
		this.amoblado = amoblado;
	}

	public Boolean getJardin() {
		return jardin;
	}

	public void setJardin(Boolean jardin) {
		this.jardin = jardin;
	}

	public Boolean getMascotas() {
		return mascotas;
	}

	public void setMascotas(Boolean mascotas) {
		this.mascotas = mascotas;
	}

}
