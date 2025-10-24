package com.devsuperior.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.aula.entities.Papel;
import com.devsuperior.aula.repositories.PapelRepository;
import com.devsuperior.aula.services.exceptions.EntidadeNaoEncontradaException;

@Service
public class PapelService {

	@Autowired
	private PapelRepository papelRep;
	
	
	
	public Papel findOrFailById(Long id) {
		return papelRep.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(id));
	}
}
