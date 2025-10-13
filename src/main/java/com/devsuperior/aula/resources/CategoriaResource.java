package com.devsuperior.aula.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
