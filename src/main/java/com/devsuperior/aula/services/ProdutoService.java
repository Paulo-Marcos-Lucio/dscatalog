package com.devsuperior.aula.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.aula.dto.CategoriaDTO;
import com.devsuperior.aula.dto.ProdutoDTO;
import com.devsuperior.aula.entities.Categoria;
import com.devsuperior.aula.entities.Produto;
import com.devsuperior.aula.repositories.ProdutoRepository;
import com.devsuperior.aula.services.exceptions.EntidadeEmUsoException;
import com.devsuperior.aula.services.exceptions.EntidadeNaoEncontradaException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository prodRep;
	
	@Autowired
	private CategoriaService catServ;
	
	
	@Transactional(readOnly = true)
	public Page<ProdutoDTO> findAllPaged(Pageable pageable) {
		Page<Produto> Produtos = prodRep.findAll(pageable);
	
		return Produtos
			.map(ProdutoBd -> new ProdutoDTO(ProdutoBd));

	}
	
	
	
	@Transactional(readOnly = true)
	public ProdutoDTO findById(Long id) {
		Optional<Produto> produto = prodRep.findById(id);
		
		Produto prodBD = produto.orElseThrow(() ->
				new EntidadeNaoEncontradaException(
						"Entidade não encontrada."));
				
		return new ProdutoDTO(prodBD, prodBD.getCategorias());
	}
	
	
	@Transactional
	public ProdutoDTO insert(ProdutoDTO prodDTO) {
		Produto prodBD = new Produto();
		copyDtoToEntity(prodDTO, prodBD);
		prodBD = prodRep.save(prodBD);
		return new ProdutoDTO(prodBD);
	}
	
	
	@Transactional
	public ProdutoDTO update(Long id, ProdutoDTO prodDTO) {
		Produto prodBD = findOrFailById(id);
		copyDtoToEntity(prodDTO, prodBD);
		prodBD = prodRep.save(prodBD);
		return new ProdutoDTO(prodBD);
	}
	
	
	@Transactional
	public void delete(Long id) {
		try {
			findOrFailById(id);
			prodRep.deleteById(id);
			prodRep.flush();
			}
		catch(DataIntegrityViolationException ex) {
			throw new EntidadeEmUsoException(id);
		}
	}
	
	
	public Produto findOrFailById(Long id) {
		return prodRep.findById(id)
			.orElseThrow(() -> new EntidadeNaoEncontradaException(id));
	}
	
	
	private void copyDtoToEntity(ProdutoDTO prodDTO, Produto prodBD) {
		prodBD.setNome(prodDTO.getNome());
		prodBD.setDescricao(prodDTO.getDescricao());
		prodBD.setPreco(prodDTO.getPreco());
		prodBD.setImgUrl(prodDTO.getImgUrl());
		prodBD.setDate(prodDTO.getDate());
		
		prodBD.getCategorias().clear();
		
		for(CategoriaDTO catDTO : prodDTO.getCategorias()) {
			Categoria categoriaBD = catServ.findOrFailById(catDTO.getId());
			prodBD.getCategorias().add(categoriaBD);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
