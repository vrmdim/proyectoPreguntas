package com.mdef.gestionpreguntas.REST;

import org.springframework.hateoas.RepresentationModel;

public class UsuarioListaModel extends RepresentationModel<UsuarioListaModel>{
	
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "UsuarioListaModel [nombre=" + nombre + "]";
	}
	
	
		
}
