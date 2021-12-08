package com.example.demo.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class Propiedad {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String zona;
	private String direccion;
	private Integer piso;
	private Double superficie;
	private Integer banios;
	private String estacionamiento;
	private Double precio;
	private String tipoDePropiedad;

	@Temporal(TemporalType.TIMESTAMP)
	private Date disponibilidadInicio;

	@Temporal(TemporalType.TIMESTAMP)
	private Date disponibilidadFinal;

	private String expensas;
	private Integer plantas;
	private String antiguedad;
	private String operacion;
	private Integer dormitorios;
	private Integer ambientes;
	private String amoblado;
	private String mascotas;
	
	@OneToOne
	private Foto foto;

	@ManyToOne
	private Propietario propietario;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Double superficie) {
		this.superficie = superficie;
	}

	public Integer getBanios() {
		return banios;
	}

	public void setBanios(Integer banios) {
		this.banios = banios;
	}

	public String getEstacionamiento() {
		return estacionamiento;
	}

	public void setEstacionamiento(String estacionamiento) {
		this.estacionamiento = estacionamiento;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getDisponibilidadInicio() {
		return disponibilidadInicio;
	}

	public void setDisponibilidadInicio(Date disponibilidadInicio) {
		this.disponibilidadInicio = disponibilidadInicio;
	}

	public Date getDisponibilidadFinal() {
		return disponibilidadFinal;
	}

	public void setDisponibilidadFinal(Date disponibilidadFinal) {
		this.disponibilidadFinal = disponibilidadFinal;
	}

	public String getExpensas() {
		return expensas;
	}

	public void setExpensas(String expensas) {
		this.expensas = expensas;
	}

	public Integer getPlantas() {
		return plantas;
	}

	public void setPlantas(Integer plantas) {
		this.plantas = plantas;
	}

	public String getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}


	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
	public String getOperacion() {
		return operacion;
	}
	
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

}
