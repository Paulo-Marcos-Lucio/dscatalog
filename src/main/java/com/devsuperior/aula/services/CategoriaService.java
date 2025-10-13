package com.devsuperior.aula.services;

import java.util.List;
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
}
