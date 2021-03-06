package ServiciosPropiedad;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import EntidadesPropiedad.Casa;
import EntidadesPropiedad.Propiedad;
import EntidadesUsuario.Propietario;
import ServiciosUsuario.ErrorServicio;

@Service
public class CasaService {

	//@Autowired
	//private InquilinoRepositorio inquilinoRepositorio;
	
public void CrearCasa(Integer dormitorios, Integer ambientes, Boolean amoblado, Boolean jardin, Boolean mascotas, String idp) throws ErrorServicio {
		
		Validar(dormitorios, ambientes, amoblado, jardin, mascotas, idp);
		
		Casa casa = new Casa();
		
		Optional<Propiedad> respuesta = propiedadRepositorio.findById(idp);
		
		if(respuesta.isPresent()) {
			
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
			casa.setAlquiler(propiedad.getAlquiler());
			casa.setVenta(propiedad.getVenta());
			casa.setId(propiedad.getId());
			
		}else {
			throw new ErrorServicio("No se encontro la casa solicitada");
		}
		
		casa.setDomritorios(dormitorios);
		casa.setAmbientes(ambientes);
		casa.setAmoblado(amoblado);
		casa.setJardin(jardin);
		casa.setMascotas(mascotas);
		
		casaRepositorio.save(casa);
	}
	
	public void Validar(Integer dormitorios, Integer ambientes, Boolean amoblado, Boolean jardin, Boolean mascotas, String idp) throws ErrorServicio{
		
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

	public void ModificarCasa(String id, String zona, String direccion, Double superficie, Integer banios, Boolean estacionamiento, Double precio, Date disponibilidadInicio, Date disponibilidadFinal, Double expensas, Integer plantas, Integer antiguedad, Boolean alquiler, Boolean venta, String prop, Integer dormitorios, Integer ambientes, Boolean amoblado, Boolean jardin, Boolean mascotas, String idp) throws ErrorServicio{
		Optional<Casa> respuesta = casaRepositorio.findById(id);
		Propietario propietario = propietarioRepositorio.getById(prop);
		Propiedad propiedad = propiedadRepositorio.getById(idp);
		
		if(respuesta.isPresent()) {
			
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
			casa.setAlquiler(alquiler);
			casa.setVenta(venta);
			casa.setPropietario(propietarioRepositorio.findById(prop));
			casa.setDomritorios(dormitorios);
			casa.setAmbientes(ambientes);
			casa.setAmoblado(amoblado);
			casa.setJardin(jardin);
			casa.setMascotas(mascotas);
			
			casaRepositorio.save(casa);
		}else {
			throw new ErrorServicio("No se encontro la casa solicitada");
		}
	}
	
	public void EliminarCasa(String id) throws ErrorServicio{
		
		Optional<Casa> respuesta = casaRepositorio.findById(id);
		
		if(respuesta.isPresent()) {
			
			Casa casa = respuesta.get();
			
			casaRepositorio.deleteById(id);
			
		}else {
			throw new ErrorServicio("No se encontro la casa solicitada");
		}
	}
}
