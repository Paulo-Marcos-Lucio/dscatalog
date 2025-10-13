package com.devsuperior.aula.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.aula.dto.CategoriaDTO;
import com.devsuperior.aula.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService catServ;
	
	
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		return ResponseEntity.ok().body(catServ.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDTO> findById(@PathVariable Long id) {
		CategoriaDTO catDTO = catServ.findById(id);
		return ResponseEntity.ok().body(catDTO);
	}
	
	
	@PostMapping
	public ResponseEntity<CategoriaDTO> insert(@RequestBody CategoriaDTO catDTO) {
		catDTO = catServ.insert(catDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(catDTO.getId()).toUri();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(catDTO);
	}
}
