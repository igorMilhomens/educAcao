package org.generation.educAcao.controller;

import java.util.List;

import org.generation.educAcao.model.ComentarioPostagem;
import org.generation.educAcao.repository.ComentarioPostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/comentarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ComentarioPostagemController {

	@Autowired
	private ComentarioPostagemRepository repositoty;
	
	@GetMapping
	public ResponseEntity<List<ComentarioPostagem>> GetAll(){
		return ResponseEntity.ok(repositoty.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ComentarioPostagem> GetById(@PathVariable long id){
		return repositoty.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<ComentarioPostagem> post(@RequestBody ComentarioPostagem comentario){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoty.save(comentario));
	}
	
	@PutMapping
	public ResponseEntity<ComentarioPostagem> put(@RequestBody ComentarioPostagem comentario){
		return ResponseEntity.status(HttpStatus.OK).body(repositoty.save(comentario));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repositoty.deleteById(id);
	}	
	
}
