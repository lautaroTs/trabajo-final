package com.example.demo.servicio;

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
	PropiedadRepositorio propiedadRepositorio;

	@Autowired
	PropietarioRepositorio propietarioRepositorio;

	@Autowired
	FotoService fotoService;

	@Transactional
	public Propiedad crearPropiedad(String zona, String direccion, Double superficie, Integer banios,
			String estacionamiento, Double precio, String tipoDePropiedad, String expensas, Integer plantas,
			String antiguedad, String operacion, Integer dormitorios, Integer ambientes, String amoblado,
			String mascotas) throws ErrorServicio {
<<<<<<< HEAD

		Validar(zona, direccion, superficie, banios, estacionamiento, precio, tipoDePropiedad, expensas, plantas,
				antiguedad, operacion, dormitorios, ambientes, amoblado, mascotas);

		Propiedad propiedad = new Propiedad();
//		Optional<Propietario> respuesta = propietarioRepositorio.buscarPorEmail(propietario.getEmail());

		propiedad.setZona(zona);
		propiedad.setDireccion(direccion);
		propiedad.setSuperficie(superficie);
		propiedad.setBanios(banios);
		propiedad.setEstacionamiento(estacionamiento);
		propiedad.setTipoDePropiedad(tipoDePropiedad);
		propiedad.setPrecio(precio);
//		propiedad.setDisponibilidadInicio(disponibilidadInicio);
//		propiedad.setDisponibilidadFinal(disponibilidadFinal);
		propiedad.setExpensas(expensas);
		propiedad.setPlantas(plantas);
		propiedad.setAntiguedad(antiguedad);
		propiedad.setOperacion(operacion);
		propiedad.setDormitorios(dormitorios);
		propiedad.setAmbientes(ambientes);
		propiedad.setAmoblado(amoblado);
		propiedad.setMascotas(mascotas);
//		Foto foto = fotoService.guardar(archivo);
//		propiedad.setFoto(foto);

//		if (respuesta.isPresent()) {
//			propiedad.setPropietario(respuesta.get());
//		}

		propiedadRepositorio.save(propiedad);
		return propiedad;
=======
		try {
			Validar(zona, direccion, superficie, banios, estacionamiento, precio, tipoDePropiedad, expensas, plantas,
					antiguedad, operacion, dormitorios, ambientes, amoblado, mascotas);

			Propiedad propiedad = new Propiedad();
//	Optional<Propietario> respuesta = propietarioRepositorio.buscarPorEmail(propietario.getEmail());

			propiedad.setZona(zona);
			propiedad.setDireccion(direccion);
			propiedad.setSuperficie(superficie);
			propiedad.setBanios(banios);
			propiedad.setEstacionamiento(estacionamiento);
			propiedad.setTipoDePropiedad(tipoDePropiedad);
			propiedad.setPrecio(precio);
//	propiedad.setDisponibilidadInicio(disponibilidadInicio);
//	propiedad.setDisponibilidadFinal(disponibilidadFinal);
			propiedad.setExpensas(expensas);
			propiedad.setPlantas(plantas);
			propiedad.setAntiguedad(antiguedad);
			propiedad.setOperacion(operacion);
			propiedad.setDormitorios(dormitorios);
			propiedad.setAmbientes(ambientes);
			propiedad.setAmoblado(amoblado);
			propiedad.setMascotas(mascotas);
//	Foto foto = fotoService.guardar(archivo);
//	propiedad.setFoto(foto);

//	if (respuesta.isPresent()) {
//		propiedad.setPropietario(respuesta.get());
//	}
			propiedadRepositorio.save(propiedad);
			return propiedad;
		} catch (Exception e) {
			throw new ErrorServicio ("error guardando la propiedad");
		}

>>>>>>> 4112ebde9bbb6693ac4c29cada6339742ac972f1
	}

	@Transactional
	public Propiedad crearPropiedadSimple(String operacion, String zona, Propietario propietario, String direccion)
			throws ErrorServicio {

		ValidarPropiedadSimple(zona, direccion, propietario, operacion);

		Optional<Propietario> respuesta = propietarioRepositorio.buscarPorEmail(propietario.getEmail());

		Propiedad propiedad = new Propiedad();

		propiedad.setZona(zona);
		propiedad.setDireccion(direccion);
		propiedad.setOperacion(operacion);
		if (respuesta.isPresent()) {
			propiedad.setPropietario(respuesta.get());
		}

		propiedadRepositorio.save(propiedad);
		return propiedad;
	}

	public void ValidarPropiedadSimple(String zona, String direccion, Propietario propietario, String operacion)
			throws ErrorServicio {

		if (zona == null || zona.isEmpty()) {
			throw new ErrorServicio("La zona no puede ser null");
		}

		if (direccion == null || direccion.isEmpty()) {
			throw new ErrorServicio("La direccion no puede ser null");
		}

		if (propietario == null) {
			throw new ErrorServicio("El propietario no puede ser null");
		}

		if (operacion == null || operacion.isEmpty()) {
			throw new ErrorServicio("La operacion no puede ser null");
		}
	}

	public void Validar(String zona, String direccion, Double superficie, Integer banios, String estacionamiento,
			Double precio, String tipoDePropiedad, String expensas, Integer plantas, String antiguedad,
			String operacion, Integer dormitorios, Integer ambientes, String amoblado, String mascotas)
			throws ErrorServicio {

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

		if (tipoDePropiedad == null || tipoDePropiedad.isEmpty()) {
			throw new ErrorServicio("El tipo de propiedad no puede ser null");
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

		if (operacion == null || operacion.isEmpty()) {
			throw new ErrorServicio("La operacion no puede ser null");
		}

		if (dormitorios == null) {
			throw new ErrorServicio("Los dormitorios no puede ser null");
		}

		if (ambientes == null) {
			throw new ErrorServicio("Ambientes no puede ser null");
		}

		if (amoblado == null) {
			throw new ErrorServicio("Amoblado no puede ser null");
		}

		if (mascotas == null) {
			throw new ErrorServicio("Mascotas no puede ser null");
		}

//		if (propietario == null) {
//			throw new ErrorServicio("El propietario no puede ser null");
//		}
	}

	@Transactional
	public void modificarPropiedad(String id, String zona, String direccion, Double superficie, Integer banios,
			String estacionamiento, Double precio, String tipoDePropiedad, String expensas, Integer plantas,
			String antiguedad, String operacion, Integer dormitorios, Integer ambientes, String amoblado,
			String mascotas) throws ErrorServicio {

		Validar(zona, direccion, superficie, banios, estacionamiento, precio, tipoDePropiedad, expensas, plantas,
				antiguedad, operacion, dormitorios, ambientes, amoblado, mascotas);

		Optional<Propiedad> respuestaPropiedad = propiedadRepositorio.findById(id);
//		Optional<Propietario> respuestaPropietario = propietarioRepositorio.buscarPorEmail(propietario.getEmail());

		if (respuestaPropiedad.isPresent()) {

			Propiedad propiedad = respuestaPropiedad.get();

			propiedad.setZona(zona);
			propiedad.setDireccion(direccion);
			propiedad.setSuperficie(superficie);
			propiedad.setBanios(banios);
			propiedad.setEstacionamiento(estacionamiento);
			propiedad.setTipoDePropiedad(tipoDePropiedad);
			propiedad.setPrecio(precio);
//			propiedad.setDisponibilidadInicio(disponibilidadInicio);
//			propiedad.setDisponibilidadFinal(disponibilidadFinal);
			propiedad.setExpensas(expensas);
			propiedad.setPlantas(plantas);
			propiedad.setAntiguedad(antiguedad);
			propiedad.setOperacion(operacion);
			propiedad.setDormitorios(dormitorios);
			propiedad.setAmbientes(ambientes);
			propiedad.setAmoblado(amoblado);
			propiedad.setMascotas(mascotas);
//			if (respuestaPropietario.isPresent()) {
//				propiedad.setPropietario(respuestaPropietario.get());
//			}

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

<<<<<<< HEAD
	public Propiedad buscarPropiedadId(String id) throws ErrorServicio {

		Optional<Propiedad> respuesta = propiedadRepositorio.findById(id);

		if (respuesta.isPresent()) {

			Propiedad propiedad = respuesta.get();

			return propiedad;

		} else {
			throw new ErrorServicio("No se encontro la propiedad solicitada");
		}
=======
	@Transactional
	public List<Propiedad> buscarPropiedadPorZona(String zona) throws ErrorServicio {

		try {
			return propiedadRepositorio.FindByZona(zona);

		} catch (Exception e) {
			throw new ErrorServicio("no se encuentra la propiedad");
		}

	}

	@Transactional
	public Propiedad buscarPropiedadPorId(String id) throws ErrorServicio {

		try {
			Optional<Propiedad> respuesta = propiedadRepositorio.FindById(id);
			return respuesta.get();

		} catch (Exception e) {
			throw new ErrorServicio("no se encuentra la propiedad a modificar");
		}

>>>>>>> 4112ebde9bbb6693ac4c29cada6339742ac972f1
	}

}
