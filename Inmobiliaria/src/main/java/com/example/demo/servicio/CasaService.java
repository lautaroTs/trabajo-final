package com.example.demo.servicio;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entidades.Casa;
import com.example.demo.entidades.Propiedad;
import com.example.demo.entidades.Propietario;
import com.example.demo.errores.ErrorServicio;
import com.example.demo.repositorio.CasaRepositorio;
import com.example.demo.repositorio.PropiedadRepositorio;
import com.example.demo.repositorio.PropietarioRepositorio;

@Service
public class CasaService {

	@Autowired
	private PropiedadRepositorio propiedadRepositorio;

	@Autowired
	private CasaRepositorio casaRepositorio;

	@Autowired
	private PropietarioRepositorio propietarioRepositorio;

	@Transactional
	public Casa CrearCasa(Integer dormitorios, Integer ambientes, Boolean amoblado, Boolean jardin, Boolean mascotas,
			String idp) throws ErrorServicio {

		Validar(dormitorios, ambientes, amoblado, jardin, mascotas, idp);

		Casa casa = new Casa();

		Optional<Propiedad> respuesta = propiedadRepositorio.findById(idp);

		if (respuesta.isPresent()) {

			Propiedad propiedad = respuesta.get();

			casa.setZona(propiedad.getZona());
			casa.setDireccion(propiedad.getDireccion());
			casa.setSuperficie(propiedad.getSuperficie());
			casa.setBanios(propiedad.getBanios());
			casa.setEstacionamiento(propiedad.getEstacionamiento());
			casa.setPrecio(propiedad.getPrecio());
			casa.setDisponibilidadInicio(propiedad.getDisponibilidadInicio());
			casa.setDisponibilidadFinal(propiedad.getDisponibilidadFinal());
			casa.setExpensas(propiedad.getExpensas());
			casa.setPlantas(propiedad.getPlantas());
			casa.setAntiguedad(propiedad.getAntiguedad());
			casa.setOperacion(propiedad.getOperacion());
			casa.setId(propiedad.getId());
			casa.setDomritorios(dormitorios);
			casa.setAmbientes(ambientes);
			casa.setAmoblado(amoblado);
			casa.setJardin(jardin);
			casa.setMascotas(mascotas);

			casaRepositorio.save(casa);
			return casa;

		} else {
			throw new ErrorServicio("No se encontro la casa solicitada");
		}

	}

	public void Validar(Integer dormitorios, Integer ambientes, Boolean amoblado, Boolean jardin, Boolean mascotas,
			String idp) throws ErrorServicio {

		if (dormitorios == null) {
			throw new ErrorServicio("Dormitorios no puede ser null");
		}

		if (ambientes == null) {
			throw new ErrorServicio("Ambientes no puede ser null");
		}

		if (amoblado == null) {
			throw new ErrorServicio("Amoblado no puede ser null");
		}

		if (jardin == null) {
			throw new ErrorServicio("Jardin no puede ser null");
		}

		if (mascotas == null) {
			throw new ErrorServicio("Mascotas no puede ser null");
		}

		if (idp == null) {
			throw new ErrorServicio("idPropiedad no puede ser null");
		}

	}

	@Transactional
	public void ModificarCasa(String id, String zona, String direccion, Double superficie, Integer banios,
			Boolean estacionamiento, Double precio, Date disponibilidadInicio, Date disponibilidadFinal,
			Double expensas, Integer plantas, Integer antiguedad, String operacion, String prop, Integer dormitorios,
			Integer ambientes, Boolean amoblado, Boolean jardin, Boolean mascotas, String idp) throws ErrorServicio {
		Optional<Casa> respuesta = casaRepositorio.findById(id);
		Propietario propietario = propietarioRepositorio.getById(prop);
		// Propiedad propiedad = propiedadRepositorio.getById(idp);

		if (respuesta.isPresent()) {

			Casa casa = respuesta.get();

			casa.setZona(zona);
			casa.setDireccion(direccion);
			casa.setSuperficie(superficie);
			casa.setBanios(banios);
			casa.setEstacionamiento(estacionamiento);
			casa.setPrecio(precio);
			casa.setDisponibilidadInicio(disponibilidadInicio);
			casa.setDisponibilidadFinal(disponibilidadFinal);
			casa.setExpensas(expensas);
			casa.setPlantas(plantas);
			casa.setAntiguedad(antiguedad);
			casa.getOperacion();
			casa.setPropietario(propietario); // Estará bien o va propietario.get?
			casa.setDomritorios(dormitorios);
			casa.setAmbientes(ambientes);
			casa.setAmoblado(amoblado);
			casa.setJardin(jardin);
			casa.setMascotas(mascotas);

			casaRepositorio.save(casa);
		} else {
			throw new ErrorServicio("No se encontro la casa solicitada");
		}
	}

	public void EliminarCasa(String id) throws ErrorServicio {

		Optional<Casa> respuesta = casaRepositorio.findById(id);

		if (respuesta.isPresent()) {

			Casa casa = respuesta.get();

			casaRepositorio.delete(casa);

		} else {
			throw new ErrorServicio("No se encontro la casa solicitada");
		}
	}

	@Transactional
	public List<Casa> listarCasa() {
		return casaRepositorio.findAll();

	}
}
