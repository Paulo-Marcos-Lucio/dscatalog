package com.devsuperior.aula.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.aula.entities.Categoria;
import com.devsuperior.aula.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository catRep;
	
	public List<Categoria> findAll() {
		List<Categoria> categorias = catRep.findAll();
		return categorias;
	}
}
