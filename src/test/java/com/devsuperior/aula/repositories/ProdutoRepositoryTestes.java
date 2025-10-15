package com.devsuperior.aula.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.devsuperior.aula.entities.Produto;
import com.devsuperior.aula.factory.ProdutoFactory;

@DataJpaTest
public class ProdutoRepositoryTestes {

	@Autowired
	private ProdutoRepository prodRep;
	
	private Long idExistente;
	private Long idNulo;
	private Long numeroTotalProdutos;
	private Long idNaoExistente;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		idExistente = 1L;
		idNulo = null;
		numeroTotalProdutos = 26L;
		idNaoExistente = 194L;
	}
	
	
	
	@Test
	public void deleteDeveDeletarObjExistente() {
		prodRep.deleteById(idExistente);
		Optional<Produto> result = prodRep.findById(1L);
		Assertions.assertFalse(result.isPresent());
	}
	
	
	@Test
	public void salvarDevePersistirProdutoComAutoIncrementoIdNull() {
		Produto produto = ProdutoFactory.criaProduto();
		produto.setId(idNulo);
		
		produto = prodRep.save(produto);
		
		Assertions.assertNotNull(produto.getId());
		Assertions.assertEquals(numeroTotalProdutos, produto.getId());
	}
	
	
	@Test
	public void findByIdDeveRetornarProdutoQuandoIdExistir() {
		Optional<Produto> produto = prodRep.findById(idExistente);
		Assertions.assertTrue(produto.isPresent());
	}
	
	
	@Test
	public void findByIdDeveRetornarVazioQuandoIdNaoExistente() {
		Optional<Produto> produto = prodRep.findById(idNaoExistente);
		Assertions.assertTrue(produto.isEmpty());
	}
	
	
}
