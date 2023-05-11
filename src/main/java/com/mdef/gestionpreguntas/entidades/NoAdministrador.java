package com.mdef.gestionpreguntas.entidades;



public class NoAdministrador extends Usuario {
	
	private static final long serialVersionUID = 1L;
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
		super.setRole(Usuario.Role.NoAdministrador);
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
