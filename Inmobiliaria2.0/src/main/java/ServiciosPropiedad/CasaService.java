package ServiciosPropiedad;

import java.util.Optional;

import org.springframework.stereotype.Service;

import EntidadesPropiedad.Casa;
import EntidadesPropiedad.Propiedad;
import EntidadesUsuario.Usuario;
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
			throw new ErrorServicio("No se encontro el inquilino solicitado");
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

}
