package com.mdef.gestionpreguntas.REST;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.mdef.gestionpreguntas.entidades.Pregunta;

@Component
public class PreguntaAssembler implements RepresentationModelAssembler<Pregunta, PreguntaModel> {

	@Override
	public PreguntaModel toModel(Pregunta entity) {
		
		PreguntaModel model = new PreguntaModel();
		model.setEnunciado(entity.getEnunciado());
		model.setUsuario(entity.getUsuario());
		model.setFamilia(entity.getFamilia());
		
		model.add(
				linkTo(methodOn(PreguntaController.class).one(entity.getId())).withSelfRel(),
				linkTo(methodOn(UsuarioController.class).one(entity.getUsuario().getId())).withRel("usuario"),
				linkTo(methodOn(FamiliaController.class).one(entity.getFamilia().getId())).withRel("familia")
				);
		return model;
	}
		
	public Pregunta toEntity(PreguntaPostModel model) {
		Pregunta pregunta = new Pregunta();
		
		pregunta.setEnunciado(model.getEnunciado());
		pregunta.setUsuario(model.getUsuario());
		pregunta.setFamilia(model.getFamilia());
		
		return pregunta;
		
	}
	 
}
