package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Propiedad;

@Repository
public interface PropiedadRepositorio extends JpaRepository<Propiedad, String> {

	@Query(value = "SELECT a FROM Local a")
	List<Propiedad> findAllpropiedades();
}
