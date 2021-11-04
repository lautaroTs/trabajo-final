package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Administracion;
@Repository
public interface AdministracionRepositorio extends JpaRepository<Administracion, String> {

	@Query(value= "SELECT a FROM Administracion a")
	List<Administracion>findAllAdministraciones();
}
