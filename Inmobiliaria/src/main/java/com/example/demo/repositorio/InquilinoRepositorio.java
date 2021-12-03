package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Inquilino;

@Repository
public interface InquilinoRepositorio extends JpaRepository<Inquilino, String> {

	@Query(value = "SELECT a FROM Inquilino a")
	List<Inquilino> findAllinquilinos();
}