package com.devsuperior.aula.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.aula.dto.CategoriaDTO;
import com.devsuperior.aula.entities.Categoria;
import com.devsuperior.aula.repositories.CategoriaRepository;
import com.devsuperior.aula.services.exceptions.EntidadeEmUsoException;
import com.devsuperior.aula.services.exceptions.EntidadeNaoEncontradaException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository catRep;
	
	
	
	@Transactional(readOnly = true)
	public Page<CategoriaDTO> findAllPaged(Pageable pageable) {
		Page<Categoria> categorias = catRep.findAll(pageable);
		
		return categorias
			.map(categoriaBd -> new CategoriaDTO(categoriaBd));

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
	
	
	@Transactional
	public CategoriaDTO update(Long id, CategoriaDTO catDTO) {
		Categoria catBD = findOrFailById(id);
		catBD.setNome(catDTO.getNome());
		catBD = catRep.save(catBD);
		return new CategoriaDTO(catBD);
	}
	
	
	@Transactional
	public void delete(Long id) {
		try {
			Categoria catBD = findOrFailById(id);
			catRep.delete(catBD);
			catRep.flush();
			}
		catch(DataIntegrityViolationException ex) {
			throw new EntidadeEmUsoException(id);
		}
	}
	
	
	public Categoria findOrFailById(Long id) {
		return catRep.findById(id)
			.orElseThrow(() -> new EntidadeNaoEncontradaException(id));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
