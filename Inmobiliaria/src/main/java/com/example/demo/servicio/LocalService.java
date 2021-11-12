package com.example.demo.servicio;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entidades.Inquilino;
import com.example.demo.entidades.Local;
import com.example.demo.entidades.Propiedad;
import com.example.demo.errores.ErrorServicio;
import com.example.demo.repositorio.LocalRepositorio;
import com.example.demo.repositorio.PropiedadRepositorio;

public class LocalService {
@Autowired
private PropiedadRepositorio propiedadRepositorio;

@Autowired
private LocalRepositorio localRepositorio;
	
	public Local CrearLocal(String idp) throws ErrorServicio {
		
		Validar(idp);
		
		Local local = new Local();
		
		Optional<Propiedad> respuesta = propiedadRepositorio.findById(idp);
		
		if(respuesta.isPresent()) {
			
			Propiedad propiedad = respuesta.get();
			
			local.setZona(propiedad.getZona());
			local.setDireccion(propiedad.getDireccion());
			local.setSuperficie(propiedad.getSuperficie());
			local.setBanios(propiedad.getBanios());
			local.setEstacionamiento(propiedad.getEstacionamiento());
			local.setPrecio(propiedad.getPrecio());
			local.setDisponibilidadInicio(propiedad.getDisponibilidadInicio());
			local.setDisponibilidadFinal(propiedad.getDisponibilidadFinal());
			local.setExpensas(propiedad.getExpensas());
			local.setPlantas(propiedad.getPlantas());
			local.setAntiguedad(propiedad.getAntiguedad());
			local.setAlquiler(propiedad.getAlquiler());
			local.setVenta(propiedad.getVenta());
			local.setId(propiedad.getId());
			localRepositorio.save(local);
			
			return local;
			
		}else {
			throw new ErrorServicio("No se encontro el local solicitado");
		}
		
	
		
	}
	
	public void Validar(String idp) throws ErrorServicio {
		
		if (idp == null) {
			throw new ErrorServicio("idPropiedad no puede ser null");
		}

		
	}
	
	public void ModificarLocal(String id, String zona, String direccion, Double superficie, Integer banios, Boolean estacionamiento, Double precio, Date disponibilidadInicio, Date disponibilidadFinal, Double expensas, Integer plantas, Integer antiguedad, Boolean alquiler, Boolean venta, String idp) throws ErrorServicio{
		Optional<Local> respuesta = localRepositorio.findById(id);
		//Propiedad propiedad = propiedadRepositorio.getById(idp);
		
		if(respuesta.isPresent()) {
			
			Local local = respuesta.get();
			
			local.setZona(zona);
			local.setDireccion(direccion);
			local.setSuperficie(superficie);
			local.setBanios(banios);
			local.setEstacionamiento(estacionamiento);
			local.setPrecio(precio);
			local.setDisponibilidadInicio(disponibilidadInicio);
			local.setDisponibilidadFinal(disponibilidadFinal);
			local.setExpensas(expensas);
			local.setPlantas(plantas);
			local.setAntiguedad(antiguedad);
			local.setAlquiler(alquiler);
			local.setVenta(venta);
			
			localRepositorio.save(local);
			
		}else {
			throw new ErrorServicio("No se encontro el local solicitado");
		}
	}
	
public void EliminarLocal(String id) throws ErrorServicio{
		
		Optional<Local> respuesta = localRepositorio.findById(id);
		
		if(respuesta.isPresent()) {
			
			Local local = respuesta.get();
			
			localRepositorio.delete(local);
			
		}else {
			throw new ErrorServicio("No se encontro el local solicitado");
		}
	}
@Transactional
public List<Local> listarLocal() {
	return  localRepositorio.findAll();
	
}
}