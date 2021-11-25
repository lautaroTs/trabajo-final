package com.example.demo.servicio;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entidades.Propiedad;
import com.example.demo.entidades.Propietario;
import com.example.demo.errores.ErrorServicio;
import com.example.demo.repositorio.PropiedadRepositorio;
import com.example.demo.repositorio.PropietarioRepositorio;

@Service
public class PropiedadService {

	@Autowired
	private PropiedadRepositorio propiedadRepositorio;

	@Autowired
	private PropietarioRepositorio propietarioRepositorio;

	@Transactional
	public Propiedad CrearPropiedad(String zona, String direccion, Double superficie, Integer banios,
			Boolean estacionamiento, Double precio, Date disponibilidadInicio, Date disponibilidadFinal,
			Double expensas, Integer plantas, Integer antiguedad, Boolean alquiler, Boolean venta, String prop)
			throws ErrorServicio {

		Validar(zona, direccion, superficie, banios, estacionamiento, precio, disponibilidadInicio, disponibilidadFinal,
				expensas, plantas, antiguedad, alquiler, venta, prop);

		Propiedad propiedad = new Propiedad();

		propiedad.setZona(zona);
		propiedad.setDireccion(direccion);
		propiedad.setSuperficie(superficie);
		propiedad.setBanios(banios);
		propiedad.setEstacionamiento(estacionamiento);
		propiedad.setPrecio(precio);
		propiedad.setDisponibilidadInicio(disponibilidadInicio);
		propiedad.setDisponibilidadFinal(disponibilidadFinal);
		propiedad.setExpensas(expensas);
		propiedad.setPlantas(plantas);
		propiedad.setAntiguedad(antiguedad);
		propiedad.setAlquiler(alquiler);
		propiedad.setVenta(venta);
		propiedad.setPropietario(propietarioRepositorio.findById(prop).get());

		propiedadRepositorio.save(propiedad);
		return propiedad;
	}

	public void Validar(String zona, String direccion, Double superficie, Integer banios, Boolean estacionamiento,
			Double precio, Date disponibilidadInicio, Date disponibilidadFinal, Double expensas, Integer plantas,
			Integer antiguedad, Boolean alquiler, Boolean venta, String prop) throws ErrorServicio {

		if (zona == null || zona.isEmpty()) {
			throw new ErrorServicio("La zona no puede ser null");
		}

		if (direccion == null || direccion.isEmpty()) {
			throw new ErrorServicio("La direccion no puede ser null");
		}

		if (superficie == null) {
			throw new ErrorServicio("La superficie no puede ser null");
		}

		if (banios == null) {
			throw new ErrorServicio("Los baños no pueden ser null");
		}

		if (estacionamiento == null) {
			throw new ErrorServicio("El estacionamiento no puede ser null");
		}

		if (precio == null) {
			throw new ErrorServicio("El precio no puede ser null");
		}

		if (disponibilidadInicio == null) {
			throw new ErrorServicio("disponibilidadInicio no puede ser null");
		}

		if (disponibilidadFinal == null) {
			throw new ErrorServicio("disponibilidadFinal no puede ser null");
		}

		if (expensas == null) {
			throw new ErrorServicio("Las expensas no pueden ser null");
		}

		if (plantas == null) {
			throw new ErrorServicio("Las plantas no pueden ser null");
		}

		if (antiguedad == null) {
			throw new ErrorServicio("La antiguedad no puede ser null");
		}

		if (alquiler == null) {
			throw new ErrorServicio("El alquiler no puede ser null");
		}

		if (venta == null) {
			throw new ErrorServicio("La venta no puede ser null");
		}

		if (prop == null || prop.isEmpty()) {
			throw new ErrorServicio("El propietario no puede ser null");
		}
	}

	@Transactional
	public void ModificarPropiedad(String id, String zona, String direccion, Double superficie, Integer banios,
			Boolean estacionamiento, Double precio, Date disponibilidadInicio, Date disponibilidadFinal,
			Double expensas, Integer plantas, Integer antiguedad, Boolean alquiler, Boolean venta, String prop)
			throws ErrorServicio {

		Validar(zona, direccion, superficie, banios, estacionamiento, precio, disponibilidadInicio, disponibilidadFinal,
				expensas, plantas, antiguedad, alquiler, venta, prop);

		Optional<Propiedad> respuesta = propiedadRepositorio.findById(id);
		Propietario propietario = propietarioRepositorio.getById(prop);

		if (respuesta.isPresent()) {

			Propiedad propiedad = respuesta.get();

			propiedad.setZona(zona);
			propiedad.setDireccion(direccion);
			propiedad.setSuperficie(superficie);
			propiedad.setBanios(banios);
			propiedad.setEstacionamiento(estacionamiento);
			propiedad.setPrecio(precio);
			propiedad.setDisponibilidadInicio(disponibilidadInicio);
			propiedad.setDisponibilidadFinal(disponibilidadFinal);
			propiedad.setExpensas(expensas);
			propiedad.setPlantas(plantas);
			propiedad.setAntiguedad(antiguedad);
			propiedad.setAlquiler(alquiler);
			propiedad.setVenta(venta);
			propiedad.setPropietario(propietario);

			propiedadRepositorio.save(propiedad);

		} else {
			throw new ErrorServicio("No se encontro la propiedad solicitada");
		}
	}

	public void EliminarPropiedad(String id) throws ErrorServicio {

		Optional<Propiedad> respuesta = propiedadRepositorio.findById(id);

		if (respuesta.isPresent()) {

			Propiedad propiedad = respuesta.get();

			propiedadRepositorio.delete(propiedad);

		} else {
			throw new ErrorServicio("No se encontro la propiedad solicitada");
		}
	}

	@Transactional
	public List<Propiedad> listarPropiedad() {
		return propiedadRepositorio.findAll();

	}

	public Propiedad buscarPropiedadId(String id) throws ErrorServicio {

		Optional<Propiedad> respuesta = propiedadRepositorio.findById(id);

		if (respuesta.isPresent()) {

			Propiedad propiedad = respuesta.get();

			return propiedad;

		} else {
			throw new ErrorServicio("No se encontro la propiedad solicitada");
		}
	}
	
	
}
