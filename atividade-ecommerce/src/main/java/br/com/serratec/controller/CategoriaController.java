package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.entity.Categoria;
import br.com.serratec.repository.CategoriaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;

	@PostMapping
	public ResponseEntity<Categoria> inserir(@Valid @RequestBody Categoria c) {
		Categoria novaCategoria = repository.save(c);
			return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria);
	}

	@GetMapping
	public List<Categoria> listar() {
		return repository.findAll();
	}

	@PutMapping("{id}")
	public ResponseEntity<Categoria> alterarCategoria(@PathVariable Long id, @Valid @RequestBody Categoria c) {
		if (repository.existsById(id)) {
			c.setId(id); // 
			return ResponseEntity.ok(repository.save(c));
		}
		return ResponseEntity.notFound().build();	
	}	
}

