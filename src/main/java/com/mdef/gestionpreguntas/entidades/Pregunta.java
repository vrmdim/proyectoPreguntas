package com.mdef.gestionpreguntas.entidades;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="PREGUNTAS")
public class Pregunta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private String enunciado;
	
	// RELACION ONE TO MANY (pregunta hace referencia a como llame la variable en Usuario)0
	@OneToMany(mappedBy = "pregunta")
	private List<Usuario> usuarios;
	
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
