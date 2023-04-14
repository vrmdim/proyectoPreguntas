package com.mdef.gestionpreguntas.REST;

import org.springframework.hateoas.RepresentationModel;

public class UsuarioPostModel extends RepresentationModel<UsuarioPostModel>{

	private String nombre;
	private String nombreUsuario;
	private String contrasena;
	private Departamento departamento;
	private Tipo tipo;
	private String telefono;
	private Role role;
	
	
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	protected void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	protected void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	protected void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	protected void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	protected void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	protected void setRole(Role role) {
		this.role = role;
	}
	public String getNombre() {
		return nombre;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public String getTelefono() {
		return telefono;
	}
	public Role getRole() {
		return role;
	}
	@Override
	public String toString() {
		return "UsuarioPostModel [nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena
				+ ", telefono=" + telefono + "]";
	}
	
	
	
}
