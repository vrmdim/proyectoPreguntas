package com.mdef.gestionpreguntas.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.mdef.gestionpreguntas.entidades.Familia;
import com.mdef.gestionpreguntas.entidades.Usuario;

@Relation(itemRelation="pregunta")
public class PreguntaModel extends RepresentationModel<PreguntaModel>{
	
	private String enunciado;
	private Usuario usuario;
	private Familia familia;

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	@Override
	public String toString() {
		return "PreguntaModel [enunciado=" + enunciado + "]";
	}
	
	
}
