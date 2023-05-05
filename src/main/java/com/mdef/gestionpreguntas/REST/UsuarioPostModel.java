package com.mdef.gestionpreguntas.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.mdef.gestionpreguntas.entidades.NoAdministrador.Departamento;
import com.mdef.gestionpreguntas.entidades.NoAdministrador.Tipo;
import com.mdef.gestionpreguntas.entidades.Usuario.Role;


@Relation(itemRelation = "usuario")
public class UsuarioPostModel extends RepresentationModel<UsuarioPostModel>{

	private String nombre;
	private String username;
	private String password;
	private String telefono;
	private Role role;
	private Departamento departamento;
	private Tipo tipo;
	 
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getTelefono() {
		return telefono;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
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
	@Override
	public String toString() {
		return "UsuarioPostModel [nombre=" + nombre + ", nombreUsuario=" + username + ", contrasena=" + password
				+ ", telefono=" + telefono + ", role=" + role + ", departamento=" + departamento + ", tipo=" + tipo
				+ "]";
	}

	
	
	
}
