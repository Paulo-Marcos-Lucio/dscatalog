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

import com.devsuperior.aula.dto.UsuarioDTO;
import com.devsuperior.aula.dto.UsuarioInsertDTO;
import com.devsuperior.aula.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService usrServ;
	
	
	
	@GetMapping
	public ResponseEntity<Page<UsuarioDTO>> findAll(Pageable pageable) {
		Page<UsuarioDTO> prodsDTO = usrServ.findAllPaged(pageable);
		return ResponseEntity.ok().body(prodsDTO);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
		UsuarioDTO usuarioDTO = usrServ.findById(id);
		return ResponseEntity.ok().body(usuarioDTO);
	}
	
	
	@PostMapping
	public ResponseEntity<UsuarioInsertDTO> insert(@RequestBody UsuarioInsertDTO usuarioDTO) {
		usrServ.insert(usuarioDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTO);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioDTO> update(@PathVariable Long id,
								@RequestBody UsuarioDTO usuarioDTO) {
		usuarioDTO = usrServ.update(id, usuarioDTO);
		return ResponseEntity.ok().body(usuarioDTO);
		
	}
	
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		usrServ.delete(id);
	}
	
	
	
	
	
	
	
	
	
}
