package com.mdef.gestionpreguntas.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

//el discriminator value va a crear una columna con ese valor en la BBDD
@Entity
@DiscriminatorValue("Admin")
public class Administrador extends Usuario {
	
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
