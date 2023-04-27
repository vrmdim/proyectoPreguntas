package com.mdef.gestionpreguntas.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="PREGUNTAS")
public class Pregunta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private String enunciado;
	
	// RELACION ONE TO MANY (pregunta hace referencia a como llame la variable en Usuario)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuarioId", nullable = false)
	private Usuario usuario;
	
	public Long getId() {
		return id;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setId(Long id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Pregunta [id=" + id + ", enunciado=" + enunciado + ", usuario=" + usuario + "]";
	}

	
	

}
