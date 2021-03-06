package ServiciosPropiedad;

import java.util.Date;
import java.util.Optional;

import EntidadesPropiedad.Casa;
import EntidadesPropiedad.Local;
import EntidadesPropiedad.Propiedad;
import ServiciosUsuario.ErrorServicio;

public class LocalService {

	public void CrearLocal() {
		
		Validar();
		
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
			
		}else {
			throw new ErrorServicio("No se encontro el local solicitado");
		}
		
		localRepositorio.save(local);
		
	}
	
	public void Validar() {
		
	}
	
	public void ModificarLocal(String id, String zona, String direccion, Double superficie, Integer banios, Boolean estacionamiento, Double precio, Date disponibilidadInicio, Date disponibilidadFinal, Double expensas, Integer plantas, Integer antiguedad, Boolean alquiler, Boolean venta, String idp) throws ErrorServicio{
		Optional<Local> respuesta = localRepositorio.findById(id);
		Propiedad propiedad = propiedadRepositorio.getById(idp);
		
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
			
			localRepositorio.deleteById(id);
			
		}else {
			throw new ErrorServicio("No se encontro el local solicitado");
		}
	}
	
}
