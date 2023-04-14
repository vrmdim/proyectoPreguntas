package com.mdef.gestionpreguntas.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(itemRelation="usuario")
public class UsuarioModel extends RepresentationModel<UsuarioModel>{

	private String nombre;
	private String nombreUsuario;
	private Departamento departamento;
	private Tipo tipo;
	private Role role;
	
	public String getNombre() {
		return nombre;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public Role getRole() {
		return role;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	protected void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	protected void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	protected void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	protected void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UsuarioModel [nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + "]";
	}
	
	
	
}
