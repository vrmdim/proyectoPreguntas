package com.mdef.gestionpreguntas.entidades;



public class Administrador extends Usuario {
	
	private static final long serialVersionUID = 1L;

	public Administrador() {
		super();
		super.setRole(Usuario.Role.Administrador);
	}

	private String telefono;

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Administrador [telefono=" + telefono + "]";
	}
		
}
