package com.mdef.gestionpreguntas.REST;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.mdef.gestionpreguntas.entidades.Administrador;
import com.mdef.gestionpreguntas.entidades.NoAdministrador;
import com.mdef.gestionpreguntas.entidades.Usuario;


@Component
public class UsuarioAssembler implements RepresentationModelAssembler<Usuario, UsuarioModel> {

	@Override
	public UsuarioModel toModel(Usuario entity) {
		
		UsuarioModel usuarioModel;
		
		/**
		 * Compruebo el tipo de usuario que es (Administrador / NoAdministrador)
		 */
		if (entity.getRole() == Usuario.Role.Administrador) {
			UsuarioAdminModel adminModel = new UsuarioAdminModel();
			adminModel.setTelefono(((Administrador) entity).getTelefono());
			
			// meto admin model en userModel
			usuarioModel = adminModel;
		} else {
			UsuarioNoAdminModel noAdminModel = new UsuarioNoAdminModel();
			noAdminModel.setDepartamento(((NoAdministrador) entity).getDepartamento());
			noAdminModel.setTipo(((NoAdministrador) entity).getTipo());
			usuarioModel = noAdminModel;
		}
		
		
		//Añado los parámetros que tenga UsuarioModel
		usuarioModel.setNombre(entity.getNombre());
		usuarioModel.setNombreUsuario(entity.getNombreUsuario());
		usuarioModel.setRole(entity.getRole());
		
		
		
		// Puedo añadir links en el model que llega a la Vista para saber qué opciones de API hay
		usuarioModel.add(
				linkTo(methodOn(UsuarioController.class).one(entity.getId())).withSelfRel(),
				// Link de articulos HERENCIA
				linkTo(methodOn(UsuarioController.class).preguntas(entity.getId())).withRel("preguntas")
				);
				
		return usuarioModel;
	}
	
	public Usuario toEntity(UsuarioPostModel model) {
		
		Usuario usuario;
			
		if (model.getRole() == Usuario.Role.Administrador) {
			Administrador administrador = new Administrador();
			administrador.setTelefono(model.getTelefono());
			usuario = administrador;
			
		} else {
			
			NoAdministrador noAdministrador = new NoAdministrador();
			noAdministrador.setTipo(model.getTipo());
			noAdministrador.setDepartamento(model.getDepartamento());
			usuario = noAdministrador;
		}
		
		usuario.setNombre(model.getNombre());
		usuario.setNombreUsuario(model.getNombreUsuario());
		
		return usuario;
	}
	
	// Sobrecarga para UsuarioPutModel
	public Usuario toEntity(UsuarioPutModel model) {
		
		Usuario usuario;
			
		if (model.getRole() == Usuario.Role.Administrador) {
			Administrador administrador = new Administrador();
			administrador.setTelefono(model.getTelefono());
			usuario = administrador;
			
		} else {
			
			NoAdministrador noAdministrador = new NoAdministrador();
			noAdministrador.setTipo(model.getTipo());
			noAdministrador.setDepartamento(model.getDepartamento());
			usuario = noAdministrador;
		}
		
		usuario.setNombre(model.getNombre());
		usuario.setNombreUsuario(model.getNombreUsuario());
		
		// Security
		usuario.setAccountNonExpired(model.isAccountNonExpired());
		usuario.setAccountNonLocked(model.isAccountNonLocked());
		usuario.setCredentialsNonExpired(model.isCredentialsNonExpired());
		usuario.setEnabled(model.isEnabled());
		
		
		return usuario;
	}

}




