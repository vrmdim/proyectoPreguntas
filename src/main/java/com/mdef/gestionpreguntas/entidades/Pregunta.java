package com.mdef.gestionpreguntas.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PREGUNTAS")
public class Pregunta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private String enunciado;
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
	@Override
	public String toString() {
		return "Pregunta [id=" + id + ", enunciado=" + enunciado + "]";
	}
	
	

}
