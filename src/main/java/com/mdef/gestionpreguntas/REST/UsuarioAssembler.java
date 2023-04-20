package com.mdef.gestionpreguntas.REST;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.mdef.gestionpreguntas.entidades.Usuario;


@Component
public class UsuarioAssembler implements RepresentationModelAssembler<Usuario, UsuarioModel> {

	@Override
	public UsuarioModel toModel(Usuario entity) {
		
		UsuarioModel usuarioModel = new UsuarioModel();
		
		//Añado los parámetros que tenga UsuarioModel
		usuarioModel.setNombre(entity.getNombre());
		usuarioModel.setNombreUsuario(entity.getNombreUsuario());
		
		// Puedo añadir links en el model que llega a la Vista para saber qué opciones de API hay
		usuarioModel.add(
				linkTo(methodOn(UsuarioController.class).one(entity.getId())).withSelfRel()
				);
				
		return usuarioModel;
	}
	
	public Usuario toEntity(UsuarioPostModel model) {
		Usuario usuario = new Usuario();
		usuario.setNombre(model.getNombre());
		usuario.setNombreUsuario(model.getNombreUsuario());
		return usuario;
	}


}
