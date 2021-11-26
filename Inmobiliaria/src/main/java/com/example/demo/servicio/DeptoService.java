package com.example.demo.servicio;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entidades.Depto;
import com.example.demo.entidades.Propiedad;
import com.example.demo.errores.ErrorServicio;
import com.example.demo.repositorio.DeptoRepositorio;
import com.example.demo.repositorio.PropiedadRepositorio;

@Service
public class DeptoService {
	@Autowired
	private PropiedadRepositorio propiedadRepositorio;

	@Autowired
	private DeptoRepositorio departamentoRepositorio;

	@Transactional
	public Depto CrearDepartamento(Boolean amoblado, Boolean esCompartido, Integer piso, Boolean patio,
			Integer dormitorios, Integer ambientes, Boolean seguridad, Boolean mascotas, String idp)
			throws ErrorServicio {

		Validar(amoblado, esCompartido, piso, patio, dormitorios, ambientes, seguridad, mascotas, idp);

		Optional<Propiedad> respuesta = propiedadRepositorio.findById(idp);

		Depto departamento = new Depto();

		if (respuesta.isPresent()) {

			Propiedad propiedad = respuesta.get();

			departamento.setZona(propiedad.getZona());
			departamento.setDireccion(propiedad.getDireccion());
			departamento.setSuperficie(propiedad.getSuperficie());
			departamento.setBanios(propiedad.getBanios());
			departamento.setEstacionamiento(propiedad.getEstacionamiento());
			departamento.setPrecio(propiedad.getPrecio());
			departamento.setDisponibilidadInicio(propiedad.getDisponibilidadInicio());
			departamento.setDisponibilidadFinal(propiedad.getDisponibilidadFinal());
			departamento.setExpensas(propiedad.getExpensas());
			departamento.setPlantas(propiedad.getPlantas());
			departamento.setAntiguedad(propiedad.getAntiguedad());
			departamento.setAlquiler(propiedad.getAlquiler());
			departamento.setVenta(propiedad.getVenta());
			departamento.setId(propiedad.getId());
			departamento.setAmoblado(amoblado);
			departamento.setEspCompartidos(esCompartido);
			departamento.setPiso(piso);
			departamento.setPatio(patio);
			departamento.setDormitorios(dormitorios);
			departamento.setAmbientes(ambientes);
			departamento.setSeguridad(seguridad);
			departamento.setMascotas(mascotas);

			departamentoRepositorio.save(departamento);
			return departamento;

		} else {
			throw new ErrorServicio("No se encontro el departamento solicitado");
		}

	}

	public void Validar(Boolean amoblado, Boolean esCompartido, Integer piso, Boolean patio, Integer dormitorios,
			Integer ambientes, Boolean seguridad, Boolean mascotas, String idp) throws ErrorServicio {

		if (amoblado == null) {
			throw new ErrorServicio("Amoblado no puede ser null");
		}

		if (esCompartido == null) {
			throw new ErrorServicio("esCompartido no puede ser null");
		}

		if (piso == null) {
			throw new ErrorServicio("Piso no puede ser null");
		}

		if (patio == null) {
			throw new ErrorServicio("Patio no puede ser null");
		}

		if (dormitorios == null) {
			throw new ErrorServicio("Dormitorios no puede ser null");
		}

		if (ambientes == null) {
			throw new ErrorServicio("Ambientes no puede ser null");
		}

		if (seguridad == null) {
			throw new ErrorServicio("Seguridad no puede ser null");
		}

		if (mascotas == null) {
			throw new ErrorServicio("Mascotas no puede ser null");
		}

		if (idp == null) {
			throw new ErrorServicio("idPropiedad no puede ser null");
		}

	}

	@Transactional
	public void ModificarDepartamento(String id, String zona, String direccion, Double superficie, Integer banios,
			Boolean estacionamiento, Double precio, Date disponibilidadInicio, Date disponibilidadFinal,
			Double expensas, Integer plantas, Integer antiguedad, Boolean alquiler, Boolean venta, Boolean amoblado,
			Boolean esCompartido, Integer piso, Boolean patio, Integer dormitorios, Integer ambientes,
			Boolean seguridad, Boolean mascotas) throws ErrorServicio {

		Optional<Depto> respuesta = departamentoRepositorio.findById(id);

		if (respuesta.isPresent()) {

			Depto departamento = respuesta.get();

			departamento.setZona(zona);
			departamento.setDireccion(direccion);
			departamento.setSuperficie(superficie);
			departamento.setBanios(banios);
			departamento.setEstacionamiento(estacionamiento);
			departamento.setPrecio(precio);
			departamento.setDisponibilidadInicio(disponibilidadInicio);
			departamento.setDisponibilidadFinal(disponibilidadFinal);
			departamento.setExpensas(expensas);
			departamento.setPlantas(plantas);
			departamento.setAntiguedad(antiguedad);
			departamento.setAlquiler(alquiler);
			departamento.setVenta(venta);
			departamento.setAmoblado(amoblado);
			departamento.setEspCompartidos(esCompartido);
			departamento.setPiso(piso);
			departamento.setPatio(patio);
			departamento.setDormitorios(dormitorios);
			departamento.setAmbientes(ambientes);
			departamento.setSeguridad(seguridad);
			departamento.setMascotas(mascotas);

			departamentoRepositorio.save(departamento);

		} else {
			throw new ErrorServicio("No se encontro el departamento solicitado");
		}

	}

	public void EliminarDepartamento(String id) throws ErrorServicio {

		Optional<Depto> respuesta = departamentoRepositorio.findById(id);

		if (respuesta.isPresent()) {

			Depto departamento = respuesta.get();

			departamentoRepositorio.delete(departamento);

		} else {
			throw new ErrorServicio("No se encontro el departamento solicitado");
		}
	}

	@Transactional
	public List<Depto> listarDepto() {
		return departamentoRepositorio.findAll();

	}

}