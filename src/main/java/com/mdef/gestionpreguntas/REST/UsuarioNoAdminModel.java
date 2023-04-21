package com.mdef.gestionpreguntas.REST;

import com.mdef.gestionpreguntas.entidades.NoAdministrador.Departamento;
import com.mdef.gestionpreguntas.entidades.NoAdministrador.Tipo;

public class UsuarioNoAdminModel extends UsuarioModel{
	
	private Tipo tipo;
	private Departamento departamento;
	
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	@Override
	public String toString() {
		return "UsuarioNoAdminModel [tipo=" + tipo + ", departamento=" + departamento + "]";
	}

	
	
	
}
