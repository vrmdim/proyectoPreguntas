package com.mdef.gestionpreguntas.REST;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.hateoas.CollectionModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdef.gestionpreguntas.GestionpreguntasApplication;
import com.mdef.gestionpreguntas.entidades.Pregunta;
import com.mdef.gestionpreguntas.entidades.Usuario;
import com.mdef.gestionpreguntas.repositorios.PreguntaRepositorio;
import com.mdef.gestionpreguntas.repositorios.UsuarioRepositorio;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private final UsuarioRepositorio repositorio;
	private final UsuarioAssembler assembler;
	private final UsuarioListaAssembler listaAssembler;
	// HERENCIA
	private final PreguntaRepositorio preguntaRepositorio;
	private final PreguntaListaAssembler preguntaListaAssembler;
	private final Logger log;
	
	UsuarioController (UsuarioRepositorio repositorio, 
						UsuarioAssembler assembler, 
						UsuarioListaAssembler listaAssembler, 
						PreguntaRepositorio preguntaRepositorio,
						PreguntaAssembler preguntaAssembler,
						PreguntaListaAssembler preguntaListaAssembler
						) {
		this.repositorio = repositorio;
		this.assembler = assembler;
		this.listaAssembler = listaAssembler;
		this.preguntaRepositorio = preguntaRepositorio;
		this.preguntaListaAssembler = preguntaListaAssembler;
		log = GestionpreguntasApplication.log;
	}
	
	@GetMapping
	public CollectionModel<UsuarioListaModel> all() {
		return listaAssembler.toCollection(repositorio.findAll());
	}
	
	@GetMapping("{id}")
	public UsuarioModel one(@PathVariable Long id) {
		Usuario usuario = repositorio.findById(id)
				.orElseThrow(() -> new RegisterNotFoundException(id, "usuario"));
		log.info("Recuperado " + usuario);
		
		return assembler.toModel(usuario);
	}
	
	
	@GetMapping("porNombre")
	public CollectionModel<UsuarioListaModel> usuarioPorNombre(@RequestParam("nombre") String nombre) { 
		return listaAssembler.toCollection(
				repositorio.findUsuarioByNombre(nombre) 
				); 
		}
	
	// preguntas del usuario HERENCIA
	@GetMapping("{id}/preguntas")
	public CollectionModel<PreguntaListaModel> preguntas(@PathVariable long id) {
		
		List<Pregunta> preguntas = repositorio.findById(id)
				.orElseThrow(() -> new RegisterNotFoundException(id, "usuario"))
				.getPreguntas();
		
		return CollectionModel.of(
				preguntas.stream().map(pregunta -> preguntaListaAssembler.toModel(pregunta)).collect(Collectors.toList()),
				linkTo(methodOn(UsuarioController.class).one(id)).slash("preguntas").withSelfRel()
				);
		
	}
	
	// Tomas lo ha hecho asi (Hace falta crear el metodo de repositorio Pregunta
	@GetMapping("{id}/preguntas2")
	public CollectionModel<PreguntaListaModel> preguntas2(@PathVariable long id) {
		
		Usuario usuario = repositorio.findById(id)
				.orElseThrow(() -> new RegisterNotFoundException(id, "usuario"));
		log.info("Recuperadas preguntas del usuario " + usuario);
		
		return preguntaListaAssembler.toCollection(preguntaRepositorio.findPreguntaByUsuario(usuario));
		
		
		
	}
	
	@PostMapping
	public UsuarioModel add(@Valid @RequestBody UsuarioPostModel model) {
		// Seguridad contraseña
		model.setContrasena(new BCryptPasswordEncoder().encode(model.getContrasena()));
		Usuario usuario = repositorio.save(assembler.toEntity(model));
		log.info("Añadido " + usuario);
		return assembler.toModel(usuario);
	}
	
	@PutMapping("{id}")
	public UsuarioModel edit(@PathVariable Long id, @Valid @RequestBody UsuarioPutModel model){
		Usuario usuario = repositorio.findById(id).map(usr -> {
			usr.setNombre(model.getNombre());
			//METODOS SEGURIDAD
			usr.setRole(model.getRole());
			usr.setNombreUsuario(model.getNombreUsuario());
			usr.setAccountNonExpired(model.isAccountNonExpired());
			usr.setAccountNonLocked(model.isAccountNonLocked());
			usr.setCredentialsNonExpired(model.isCredentialsNonExpired());
			usr.setEnabled(model.isEnabled());
			return repositorio.save(usr);
		})
		.orElseThrow(() -> new RegisterNotFoundException(id, "usuario"));
		log.info("Actualizado " + usuario);
		return assembler.toModel(usuario);
	}
	
	@PatchMapping("{id}/cambiarContrasena")
	public UsuarioModel edit(@PathVariable Long id, @RequestBody String newPass) {
		Usuario usuario = repositorio.findById(id).map(usr -> {
			usr.setContrasena(new BCryptPasswordEncoder().encode(newPass));
			return repositorio.save(usr);
		})
		.orElseThrow(() -> new RegisterNotFoundException(id, "usuario"));
		log.info("Actualizada contraseña de " + usuario);
		return assembler.toModel(usuario);	

	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		log.info("Borrado usuario " + id);
		repositorio.deleteById(id);
	}
	
	
}
















