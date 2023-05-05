package com.mdef.gestionpreguntas.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import com.mdef.gestionpreguntas.entidades.Usuario.Role;

@Relation(itemRelation="usuario")
public class UsuarioModel extends RepresentationModel<UsuarioModel>{

	private String nombre;
	private String username;
	private Role role;	
	private String password;
	
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public String getUsername() {
		return username;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UsuarioModel [nombre=" + nombre + ", nombreUsuario=" + username + ", role=" + role + "]";
	}


	
	
	
}
