package com.example.demo.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {

	@Query(value = "SELECT a FROM Usuario a")
	List<Usuario> findAllusuarios();

	@Query("SELECT c FROM Usuario c WHERE c.email = :email")
	Optional<Usuario> buscarPorEmail(@Param("email") String email);
}