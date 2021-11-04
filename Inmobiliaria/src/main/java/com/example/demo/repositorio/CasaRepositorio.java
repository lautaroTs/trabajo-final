package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Administracion;
import com.example.demo.entidades.Casa;


@Repository
public interface CasaRepositorio extends JpaRepository<Casa, String> {

	@Query(value= "SELECT a FROM Casa a")
	List<Casa>findAllCasas();
}