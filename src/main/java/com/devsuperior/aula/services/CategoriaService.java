package com.devsuperior.aula.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.aula.dto.CategoriaDTO;
import com.devsuperior.aula.entities.Categoria;
import com.devsuperior.aula.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository catRep;
	
	
	
	@Transactional(readOnly = true)
	public List<CategoriaDTO> findAll() {
		List<Categoria> categorias = catRep.findAll();
		
		List<CategoriaDTO> categoriasDTO = 
				categorias.stream()
				.map(categoriaBd -> new CategoriaDTO(categoriaBd))
				.collect(Collectors.toList());
		
		return categoriasDTO;
	}
	
	
	
	@Transactional(readOnly = true)
	public CategoriaDTO findById(Long id) {
		Optional<Categoria> categoria = catRep.findById(id);
		
		Categoria catBD = categoria.orElseThrow(() ->
				new EntidadeNaoEncontradaException(
						"Entidade não encontrada."));
				
		return new CategoriaDTO(catBD);
	}
	
	
	@Transactional
	public CategoriaDTO insert(CategoriaDTO catDTO) {
		Categoria catBD = new Categoria();
		catBD.setNome(catDTO.getNome());
		
		catBD = catRep.save(catBD);

		return new CategoriaDTO(catBD);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
