package com.mdef.gestionpreguntas.REST;

import org.springframework.hateoas.RepresentationModel;

public class UsuarioPutModel extends RepresentationModel<UsuarioPutModel>{
	
	private String nombre;
	private String nombreUsuario;
	//private Departamento departamento;
	//private Tipo tipo;
	private String telefono;
	//private Role role;
	
	
	public String getNombre() {
		return nombre;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		return "UsuarioPutModel [nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", telefono=" + telefono
				+ "]";
	}
	
	

}
