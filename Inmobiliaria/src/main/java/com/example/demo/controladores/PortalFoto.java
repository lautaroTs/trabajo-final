package com.example.demo.controladores;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entidades.Propiedad;
import com.example.demo.errores.ErrorServicio;
import com.example.demo.servicio.PropiedadService;

@Controller
@RequestMapping("/foto")
public class PortalFoto {

    @Autowired
    private PropiedadService propiedadService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
    @GetMapping("/usuario/{id}")
    public ResponseEntity<byte[]> fotoUsuario(@PathVariable String id) {

        try {
        	Propiedad propiedad = propiedadService.buscarPropiedadId(id);
            if (propiedad.getFoto() == null) {
                throw new ErrorServicio("El usuario no tiene una foto asignada.");
            }
            byte[] foto = propiedad.getFoto().getContenido();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);

            return new ResponseEntity<>(foto, headers, HttpStatus.OK);
        } catch (ErrorServicio ex) {
            Logger.getLogger(PortalFoto.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

  
}
