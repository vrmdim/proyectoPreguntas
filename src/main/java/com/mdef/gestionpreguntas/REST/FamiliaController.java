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
import com.mdef.gestionpreguntas.entidades.Familia;
import com.mdef.gestionpreguntas.repositorios.FamiliaRepositorio;

@RestController
@RequestMapping("/familias")
public class FamiliaController {
	
	private final FamiliaRepositorio repositorio;
	private final FamiliaAssembler assembler;
	private final FamiliaListaAssembler listaAssembler;
	private final Logger log;

	FamiliaController (
				FamiliaRepositorio repositorio,
				FamiliaAssembler assembler,
				FamiliaListaAssembler listaAssembler
			) {
		
		this.repositorio = repositorio;
		this.assembler = assembler;
		this.listaAssembler = listaAssembler;
		log = GestionpreguntasApplication.log;
	}
	
	@GetMapping
	public CollectionModel<FamiliaListaModel> all() {
		return listaAssembler.toCollection(repositorio.findAll());
	}
	
	@GetMapping("{id}")
	public FamiliaModel one(@PathVariable Long id) {
		Familia familia = repositorio.findById(id)
				.orElseThrow(() -> new RegisterNotFoundException(id, "familia"));
		log.info("Recuperada " + familia);
		
		return assembler.toModel(familia);

	}
	
	@PostMapping
	public FamiliaModel add(@RequestBody FamiliaPostModel model) {
		Familia familia = repositorio.save(assembler.toEntity(model));
		log.info("Añadida " + familia);
		return assembler.toModel(familia);
		
	}
	
	
	@PutMapping("{id}")
	public FamiliaModel put(@PathVariable Long id, @RequestBody FamiliaModel model) {
		Familia familia = repositorio.findById(id).map(fam -> {
			fam.setEnunciado(model.getEnunciado());
			return repositorio.save(fam);
		})
		.orElseThrow(() -> new RegisterNotFoundException(id, "familia"));
		log.info("Actualizada " + familia);
		return assembler.toModel(familia);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		log.info("Borrada familia " + id);
		repositorio.deleteById(id);
	}
	
}
























