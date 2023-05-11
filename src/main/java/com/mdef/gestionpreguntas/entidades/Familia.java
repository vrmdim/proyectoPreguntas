package com.mdef.gestionpreguntas.entidades;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


// ENTIENDO QUE ESTA CLASE ES NECESARIA, PORQUE support.Familia NO TIENE ID, Y HAY QUE METERSELO, ENTONCES YA USO DECORADORES EN ESTA CLASE
@Entity
@Table(name="FAMILIAS")
public class Familia extends es.mdef.support.Familia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long tamano;
	// atributo enunciado lo heredamos
	
	// Relacion OneToMany Familia-Preguntas
	@OneToMany(mappedBy = "familia")
	private List<Pregunta> preguntas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTamano() {
		return tamano;
	}

	public void setTamano(Long tamano) {
		this.tamano = tamano;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	@Override
	public String toString() {
		return "Familia [id=" + id + ", tamano=" + tamano + ", preguntas=" + preguntas + "]";
	}
	
	
	
	
	

}
