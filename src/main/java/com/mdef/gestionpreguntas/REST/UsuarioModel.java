package com.mdef.gestionpreguntas.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.mdef.gestionpreguntas.entidades.NoAdministrador.Departamento;
import com.mdef.gestionpreguntas.entidades.NoAdministrador.Tipo;
import com.mdef.gestionpreguntas.entidades.Usuario.Role;

@Relation(itemRelation="usuario")
public class UsuarioModel extends RepresentationModel<UsuarioModel>{

	private String nombre;
	private String nombreUsuario;
	private Role role;
	private Departamento departamento; 
	private Tipo tipo;
	
	
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
	
	public Role getRol() {
		return role;
	}
	public void setRol(Role role) {
		this.role = role;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UsuarioModel [nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", rol=" + role
				+ ", departamento=" + departamento + ", tipo=" + tipo + ", role=" + role + "]";
	}

	
	
	
}
