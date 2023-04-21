package com.mdef.gestionpreguntas.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

// el discriminator value va a crear una columna con ese valor en la BBDD
@Entity
@DiscriminatorValue("NoAdmin")
public class NoAdministrador extends Usuario {
	
	public static enum Tipo {
		alumno,
		docente,
		administracion
	}
	
	public static enum Departamento {
		EMIES,
		CCESP
	}
	
	public NoAdministrador() {
		super();
	}

	private Departamento departamento;
	private Tipo tipo;
	
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
		return "NoAdministrador [departamento=" + departamento + ", tipo=" + tipo + "]";
	}
	
	

		
}
