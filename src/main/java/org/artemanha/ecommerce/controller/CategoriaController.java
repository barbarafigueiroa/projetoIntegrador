package org.artemanha.ecommerce.controller;

import java.util.List;

import org.artemanha.ecommerce.model.Categoria;
import org.artemanha.ecommerce.repository.CategoriaRepository;
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

/**
 * Classe categoriaController Esta Classe é responsável por controlar a entrada,
 * saida, buscar, criação, atualização e delete de informações
 * 
 * @author MarceloNegromonte
 * @since 1.0
 * 
 *        *
 */

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;

	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/artesanal/{artesanal}")
	public ResponseEntity<List<Categoria>> getByArtesanal(@PathVariable String artesanal) {
		return ResponseEntity.ok(repository.findAllByArtesanalContainingIgnoreCase(artesanal));
	}

	@GetMapping("/formapagamento/{formapagamento}")
	public ResponseEntity<List<Categoria>> getByFormaPagamento(@PathVariable String formaPagamento) {
		return ResponseEntity.ok(repository.findAllByFormaPagamentoContainingIgnoreCase(formaPagamento));
	}

	@PostMapping
	public ResponseEntity<Categoria> post(@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}

	@PutMapping
	public ResponseEntity<Categoria> put(@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}

	@DeleteMapping
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
