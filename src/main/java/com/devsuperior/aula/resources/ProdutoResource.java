package com.devsuperior.aula.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.aula.dto.ProdutoDTO;
import com.devsuperior.aula.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService prodServ;
	
	
	
	@GetMapping
	public ResponseEntity<Page<ProdutoDTO>> findAll(Pageable pageable) {
		Page<ProdutoDTO> prodsDTO = prodServ.findAllPaged(pageable);
		return ResponseEntity.ok().body(prodsDTO);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id) {
		ProdutoDTO prodDTO = prodServ.findById(id);
		return ResponseEntity.ok().body(prodDTO);
	}
	
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> insert(@RequestBody ProdutoDTO prodDTO) {
		prodDTO = prodServ.insert(prodDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(prodDTO);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<ProdutoDTO> update(@PathVariable Long id,
								@RequestBody ProdutoDTO prodDTO) {
		prodDTO = prodServ.update(id, prodDTO);
		return ResponseEntity.ok().body(prodDTO);
		
	}
	
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		prodServ.delete(id);
	}
	
	
	
	
	
	
	
	
	
}
