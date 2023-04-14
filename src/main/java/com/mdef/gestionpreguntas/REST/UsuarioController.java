package com.mdef.gestionpreguntas.REST;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdef.gestionpreguntas.repositorios.UsuarioRepositorio;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private final UsuarioRepositorio repositorio;
	private final UsuarioAssembler assembler;
	private final UsuarioListaAssembler listaAssembler;
	private final Logger log;
	
	UsuarioController (UsuarioRepositorio repositorio, UsuarioAssembler assembler, 
						UsuarioListaAssembler listaAssembler) {
		this.repositorio = repositorio;
		this.assembler = assembler;
		this.listaAssembler = listaAssembler;
	}
	
}
