package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Propietario;

@Repository
public interface PropietarioRepositorio extends JpaRepository<Propietario, String> {

	@Query(value= "SELECT a FROM Propietario a")
	List<Propietario>findAllpropietarios();
}
