package com.example.demo.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Propiedad;

@Repository
public interface PropiedadRepositorio extends JpaRepository<Propiedad, String> {

//	@Query(value = "SELECT a FROM Propiedad")
//	List<Propiedad> findAllpropiedades();
	
	@Query(value= "SELECT a FROM Propiedad a WHERE a.id = :id")
	Optional <Propiedad> FindById(@Param("id") String id);
	
	@Query(value= "SELECT a FROM Propiedad a WHERE a.zona = :zona")
	List<Propiedad> FindByZona(@Param("zona") String zona);
	
//	@Query(value= "SELECT a FROM propiedad WHERE a.operacion = :venta")
//	List<Propiedad> FindByOperacion(@Param("venta") String venta);
}
