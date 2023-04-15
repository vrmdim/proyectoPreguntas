package com.mdef.gestionpreguntas.REST;

import org.springframework.hateoas.RepresentationModel;

public class UsuarioPostModel extends RepresentationModel<UsuarioPostModel>{

	private String nombre;
	private String nombreUsuario;
	private String contrasena;
	private String telefono;
	/*
	 * private Departamento departamento; private Tipo tipo; private Role role;
	 */
	
	
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	protected void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	protected void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	protected void setTelefono(String telefono) {
		this.telefono = telefono;
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
	public String getTelefono() {
		return telefono;
	}
	@Override
	public String toString() {
		return "UsuarioPostModel [nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena
				+ ", telefono=" + telefono + "]";
	}
	
	
	
}
