package com.mdef.gestionpreguntas.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdef.gestionpreguntas.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	// Esta interfaz la puedo dejar vacia y cogerá los métodos propios de JPA
	
	// Puedo crear búsquedas personalizadas IMPORTANTE el NOMBRE --> SQL QUERY
	List<Usuario> findUsuarioByNombre(String nombre);
	
	List<Usuario> findUsuarioByNombreOrderByNombreUsuario(String nombre);
}
