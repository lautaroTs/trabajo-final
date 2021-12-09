package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.Foto;

public interface FotoRepositorio extends JpaRepository<Foto, String> {

    
}
