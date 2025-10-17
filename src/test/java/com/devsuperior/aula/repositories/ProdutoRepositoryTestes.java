package com.devsuperior.aula.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.devsuperior.aula.entities.Produto;
import com.devsuperior.aula.factory.ProdutoFactory;

@DataJpaTest
public class ProdutoRepositoryTestes {

    @Autowired
    private ProdutoRepository prodRep;

    private Long idExistente;
    private Long idInexistente;
    private Long contagemTotalProdutos;
    private Produto produto;


    @BeforeEach
    public void setUp() throws Exception {
        idExistente = 1L;
        idInexistente = 100L;
        contagemTotalProdutos = 25L;
        produto = ProdutoFactory.criaProduto();
    }


    // ========== TESTES DE DELETE ==========

    @Test
    @DisplayName("Delete deve remover produto quando ID existir")
    public void deleteDeveRemoverProdutoQuandoIdExistir() {
        prodRep.deleteById(idExistente);
        
        Optional<Produto> resultado = prodRep.findById(idExistente);
        
        Assertions.assertFalse(resultado.isPresent());
    }
    
    
    @Test
    @DisplayName("Delete não deve lançar exceção mesmo quando ID não existir")
    public void deleteNaoDeveLancarExcecaoQuandoIdNaoExistir() {
        
        // Em versões novas do Spring Data, deleteById não lança exceção
        Assertions.assertDoesNotThrow(() -> {
            prodRep.deleteById(idInexistente);
        });
        
        // Confirma que o ID realmente não existe
        Assertions.assertFalse(prodRep.existsById(idInexistente));
    }
    
    

    // ========== TESTES DE SAVE (INSERT) ==========

    @Test
    @DisplayName("Save deve persistir produto com auto incremento quando ID for nulo")
    public void saveDevePersistirComAutoIncrementoQuandoIdNulo() {
        produto.setId(null);

        produto = prodRep.save(produto);

        Assertions.assertNotNull(produto.getId());
        Assertions.assertTrue(produto.getId() > 0);
    }
    
    
    @Test
    @DisplayName("Save deve incrementar a contagem após inserir")
    public void saveDeveIncrementarContagemAposInserir() {
        produto.setId(null);
        
        long contagemAntes = prodRep.count();
        prodRep.save(produto);
        long contagemDepois = prodRep.count();
        
        Assertions.assertEquals(contagemAntes + 1, contagemDepois);
    }


    // ========== TESTES DE SAVE (UPDATE) ==========

    @Test
    @DisplayName("Save deve atualizar produto quando ID existir")
    public void saveDeveAtualizarProdutoQuandoIdExistir() {
        Produto produtoExistente = prodRep.findById(idExistente).get();
        produtoExistente.setNome("iPhone 15 Pro Max");
        produtoExistente.setPreco(7999.99);
        
        Produto produtoAtualizado = prodRep.save(produtoExistente);
        
        Assertions.assertEquals(idExistente, produtoAtualizado.getId());
        Assertions.assertEquals("iPhone 15 Pro Max", produtoAtualizado.getNome());
        Assertions.assertEquals(7999.99, produtoAtualizado.getPreco());
    }


    // ========== TESTES DE FIND ==========

    @Test
    @DisplayName("FindById deve retornar Optional com produto quando ID existir")
    public void findByIdDeveRetornarProdutoQuandoIdExistir() {
        Optional<Produto> resultado = prodRep.findById(idExistente);
        
        Assertions.assertTrue(resultado.isPresent());
        Assertions.assertEquals(idExistente, resultado.get().getId());
    }


    @Test
    @DisplayName("FindById deve retornar Optional vazio quando ID não existir")
    public void findByIdDeveRetornarVazioQuandoIdNaoExistir() {
        Optional<Produto> resultado = prodRep.findById(idInexistente);
        
        Assertions.assertTrue(resultado.isEmpty());
    }
    
    
    // ========== TESTES ADICIONAIS ==========
    
    @Test
    @DisplayName("Count deve retornar a quantidade total de produtos")
    public void countDeveRetornarQuantidadeTotal() {
        long contagem = prodRep.count();
        
        Assertions.assertEquals(contagemTotalProdutos, contagem);
    }
    
    
    @Test
    @DisplayName("ExistsById deve retornar true quando ID existir")
    public void existsByIdDeveRetornarTrueQuandoIdExistir() {
        boolean existe = prodRep.existsById(idExistente);
        
        Assertions.assertTrue(existe);
    }
    
    
    @Test
    @DisplayName("ExistsById deve retornar false quando ID não existir")
    public void existsByIdDeveRetornarFalseQuandoIdNaoExistir() {
        boolean existe = prodRep.existsById(idInexistente);
        
        Assertions.assertFalse(existe);
    }
}