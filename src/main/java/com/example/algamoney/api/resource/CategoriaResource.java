package com.example.algamoney.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney.api.model.Categoria;
import com.example.algamoney.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public ResponseEntity<List<Categoria>> listar() {

		List<Categoria> categorias = categoriaRepository.findAll();

		if (!categorias.isEmpty())
			return ResponseEntity.ok(categorias);
		else
			return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void criar (@RequestBody Categoria categoria) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
	}
	
	
	
}
