package com.example.demo.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Propietario;

@Repository
public interface PropietarioRepositorio extends JpaRepository<Propietario, String> {

//	@Query(value = "SELECT a FROM Propietario a")
//	List<Propietario> findAllpropietarios();
	
	@Query(value = "SELECT a FROM Propietario a WHERE a.email = :email")
	Optional<Propietario> buscarPorEmail(@Param("email") String email);

}
