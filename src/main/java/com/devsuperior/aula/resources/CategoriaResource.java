package com.devsuperior.aula.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.aula.dto.CategoriaDTO;
import com.devsuperior.aula.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService catServ;
	
	
	
	@GetMapping
	public ResponseEntity<Page<CategoriaDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy
			) {
		
		PageRequest pageRequest = PageRequest.of
				(page, linesPerPage, Direction.valueOf(direction) ,orderBy);
		
		Page<CategoriaDTO> catsDTO = catServ.findAllPaged(pageRequest);
		
		return ResponseEntity.ok().body(catsDTO);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDTO> findById(@PathVariable Long id) {
		CategoriaDTO catDTO = catServ.findById(id);
		return ResponseEntity.ok().body(catDTO);
	}
	
	
	@PostMapping
	public ResponseEntity<CategoriaDTO> insert(@RequestBody CategoriaDTO catDTO) {
		catDTO = catServ.insert(catDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(catDTO);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable Long id,
								@RequestBody CategoriaDTO catDTO) {
		catDTO = catServ.update(id, catDTO);
		return ResponseEntity.ok().body(catDTO);
		
	}
	
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		catServ.delete(id);
	}
	
	
	
	
	
	
	
	
	
}
