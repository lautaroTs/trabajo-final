package com.example.demo.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	public Boolean getEstacionamiento() {
		return estacionamiento;
	}
	public void setEstacionamiento(Boolean estacionamiento) {
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
	public Double getExpensas() {
		return expensas;
	}
	public void setExpensas(Double expensas) {
		this.expensas = expensas;
	}
	public Integer getPlantas() {
		return plantas;
	}
	public void setPlantas(Integer plantas) {
		this.plantas = plantas;
	}
	public Integer getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}
	public Boolean getAlquiler() {
		return alquiler;
	}
	public void setAlquiler(Boolean alquiler) {
		this.alquiler = alquiler;
	}
	public Boolean getVenta() {
		return venta;
	}
	public void setVenta(Boolean venta) {
		this.venta = venta;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
	
	
}
