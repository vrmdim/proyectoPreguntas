package com.mdef.gestionpreguntas.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(itemRelation="usuario")
public class UsuarioModel extends RepresentationModel<UsuarioModel>{

	private String nombre;
	private String nombreUsuario;
	/*
	 * private Departamento departamento; private Tipo tipo; private Role role;
	 */
	
	public String getNombre() {
		return nombre;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	@Override
	public String toString() {
		return "UsuarioModel [nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + "]";
	}
	
	
	
}
