package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Local;

@Repository
public interface LocalRepositorio extends JpaRepository<Local, String> {

	@Query(value= "SELECT a FROM Local a")
	List<Local>findAlllocales();
}