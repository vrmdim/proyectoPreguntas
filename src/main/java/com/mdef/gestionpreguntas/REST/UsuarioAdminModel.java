package com.mdef.gestionpreguntas.REST;

public class UsuarioAdminModel extends UsuarioModel{
	
	private String telefono;

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "UsuarioAdminModel [telefono=" + telefono + "]";
	}
	
	
}
