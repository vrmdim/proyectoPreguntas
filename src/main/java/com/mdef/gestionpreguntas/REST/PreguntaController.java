package com.mdef.gestionpreguntas.REST;

import org.slf4j.Logger;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdef.gestionpreguntas.GestionpreguntasApplication;
import com.mdef.gestionpreguntas.entidades.Pregunta;
import com.mdef.gestionpreguntas.repositorios.PreguntaRepositorio;

@RestController
@RequestMapping("/preguntas")
public class PreguntaController {

	private final PreguntaRepositorio repositorio;
	private final PreguntaAssembler assembler;
	private final PreguntaListaAssembler listaAssembler;
	private final Logger log;
	
	PreguntaController (PreguntaRepositorio repositorio, PreguntaAssembler assembler,
						PreguntaListaAssembler listaAssembler) {
		this.repositorio = repositorio;
		this.assembler = assembler;
		this.listaAssembler = listaAssembler;
		log = GestionpreguntasApplication.log;
	}
	
	@GetMapping
	public CollectionModel<PreguntaListaModel> all() {
		return listaAssembler.toCollection(repositorio.findAll());
	}
	
	@GetMapping("{id}")
	public PreguntaModel one(@PathVariable Long id) {
		Pregunta pregunta = repositorio.findById(id)
				.orElseThrow(() -> new RegisterNotFoundException(id, "pregunta"));
		log.info("Recuperada " + pregunta);
		
		return assembler.toModel(pregunta);

	}
	
	@PostMapping
	public PreguntaModel add(@RequestBody PreguntaPostModel model) {
		Pregunta pregunta = repositorio.save(assembler.toEntity(model));
		log.info("Añadida " + pregunta);
		return assembler.toModel(pregunta);
		
	}
	
	
	@PutMapping("{id}")
	public PreguntaModel pit(@PathVariable Long id, @RequestBody PreguntaModel model) {
		Pregunta pregunta = repositorio.findById(id).map(prg -> {
			prg.setEnunciado(model.getEnunciado());
			return repositorio.save(prg);
		})
		.orElseThrow(() -> new RegisterNotFoundException(id, "pregunta"));
		log.info("Actualizada " + pregunta);
		return assembler.toModel(pregunta);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		log.info("Borrada pregunta " + id);
		repositorio.deleteById(id);
	}
	
	
}























