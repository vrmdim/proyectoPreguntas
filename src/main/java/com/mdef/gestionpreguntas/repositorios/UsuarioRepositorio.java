package com.mdef.gestionpreguntas.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdef.gestionpreguntas.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	// Esta interfaz la puedo dejar vacia y cogerá los métodos propios de JPA
	
	// Puedo crear búsquedas personalizadas IMPORTANTE el NOMBRE --> SQL QUERY
	//@Query("SELECT u FROM USUARIO u WHERE u.nombre = :nombre")
	List<Usuario> findUsuarioByNombre(String nombre);
	
	List<Usuario> findUsuarioByNombreOrderByNombreUsuario(String nombre);
	
	// SEGURIDAD
	Optional<Usuario> findByNombreUsuario(String nombreUsuario);

	
}
