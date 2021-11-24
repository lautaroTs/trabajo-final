package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Depto;

@Repository
public interface DeptoRepositorio extends JpaRepository<Depto, String> {

	@Query(value= "SELECT a FROM Depto a")
	List<Depto>findAllDeptos();
}
