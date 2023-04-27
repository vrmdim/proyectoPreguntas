package com.mdef.gestionpreguntas.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdef.gestionpreguntas.entidades.Pregunta;
import com.mdef.gestionpreguntas.entidades.Usuario;

public interface PreguntaRepositorio extends JpaRepository<Pregunta, Long>{
	
	List<Pregunta> findPreguntaByUsuario(Usuario usuario);
}
