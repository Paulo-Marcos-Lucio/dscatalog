package com.devsuperior.aula.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.devsuperior.aula.dto.ProdutoDTO;
import com.devsuperior.aula.entities.Categoria;
import com.devsuperior.aula.entities.Produto;
import com.devsuperior.aula.factory.ProdutoFactory;
import com.devsuperior.aula.repositories.ProdutoRepository;
import com.devsuperior.aula.services.exceptions.EntidadeEmUsoException;
import com.devsuperior.aula.services.exceptions.EntidadeNaoEncontradaException;

@ExtendWith(SpringExtension.class)
public class ProdutoServiceTest {

    @InjectMocks
    private ProdutoService prodServ;

    @Mock
    private ProdutoRepository prodRep;
    
    @Mock
    private CategoriaService catServ;

    private Long idExistente;
    private Long idInexistente;
    private Long idDependente; // ID com integridade referencial
    private Produto produto;
    private ProdutoDTO produtoDTO;
    private Categoria categoria;
    private PageImpl<Produto> page;



    @BeforeEach
    public void setUp() throws Exception {
        idExistente = 5L;
        idInexistente = 999L;
        idDependente = 2L;
        
        produto = ProdutoFactory.criaProduto();
        produto.setId(idExistente);
        
        produtoDTO = ProdutoFactory.criaProdutoDTO();
        
        categoria = new Categoria(1L, "Eletrônicos");
        
        page = new PageImpl<>(List.of(produto));

        // ===== CONFIGURAÇÃO DOS MOCKS =====
        
        // findById - ID existente
        Mockito.when(prodRep.findById(idExistente))
               .thenReturn(Optional.of(produto));

        // findById - ID inexistente
        Mockito.when(prodRep.findById(idInexistente))
               .thenReturn(Optional.empty());
        
        // save
        Mockito.when(prodRep.save(any(Produto.class)))
               .thenReturn(produto);
        
        // findAll (paginado)
        Mockito.when(prodRep.findAll(any(Pageable.class)))
               .thenReturn(page);

        // deleteById - ID existente (não faz nada)
        Mockito.doNothing().when(prodRep).deleteById(idExistente);
        
        // deleteById - ID com dependência (lança exceção)
        Mockito.doThrow(DataIntegrityViolationException.class)
               .when(prodRep).deleteById(idDependente);
        
        // CategoriaService
        Mockito.when(catServ.findOrFailById(anyLong()))
               .thenReturn(categoria);
    }


    // ========== TESTES DE DELETE ==========

    @Test
    @DisplayName("Delete não deve lançar exceção quando ID existir")
    public void deleteNaoDeveLancarExcecaoQuandoIdExistir() {
        Assertions.assertDoesNotThrow(() -> {
            prodServ.delete(idExistente);
        });

        Mockito.verify(prodRep).findById(idExistente);
        Mockito.verify(prodRep).deleteById(idExistente);
        Mockito.verify(prodRep).flush();
    }


    @Test
    @DisplayName("Delete deve lançar EntidadeNaoEncontradaException quando ID não existir")
    public void deleteDeveLancarExcecaoQuandoIdNaoExistir() {
        Assertions.assertThrows(EntidadeNaoEncontradaException.class, () -> {
            prodServ.delete(idInexistente);
        });
        
        Mockito.verify(prodRep).findById(idInexistente);
        Mockito.verify(prodRep, Mockito.never()).deleteById(idInexistente);
    }
    
    
    @Test
    @DisplayName("Delete deve lançar EntidadeEmUsoException quando houver integridade referencial")
    public void deleteDeveLancarExcecaoQuandoHouverIntegridade() {
        Mockito.when(prodRep.findById(idDependente))
               .thenReturn(Optional.of(produto));
        
        Assertions.assertThrows(EntidadeEmUsoException.class, () -> {
            prodServ.delete(idDependente);
        });
        
        Mockito.verify(prodRep).findById(idDependente);
        Mockito.verify(prodRep).deleteById(idDependente);
    }


    // ========== TESTES DE CONSULTA ==========

    @Test
    @DisplayName("FindById deve retornar ProdutoDTO quando ID existir")
    public void findByIdDeveRetornarProdutoDTOQuandoIdExistir() {
        ProdutoDTO resultado = prodServ.findById(idExistente);

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(idExistente, resultado.getId());
        Assertions.assertEquals("Iphone", resultado.getNome());
        
        Mockito.verify(prodRep).findById(idExistente);
    }


    @Test
    @DisplayName("FindById deve lançar EntidadeNaoEncontradaException quando ID não existir")
    public void findByIdDeveLancarExcecaoQuandoIdNaoExistir() {
        Assertions.assertThrows(EntidadeNaoEncontradaException.class, () -> {
            prodServ.findById(idInexistente);
        });
        
        Mockito.verify(prodRep).findById(idInexistente);
    }
    
    
    @Test
    @DisplayName("FindAllPaged deve retornar página de ProdutoDTO")
    public void findAllPagedDeveRetornarPagina() {
        Pageable pageable = PageRequest.of(0, 10);
        
        Page<ProdutoDTO> resultado = prodServ.findAllPaged(pageable);
        
        Assertions.assertNotNull(resultado);
        Assertions.assertFalse(resultado.isEmpty());
        Assertions.assertEquals(1, resultado.getSize());
        
        Mockito.verify(prodRep).findAll(pageable);
    }


    // ========== TESTES DE INSERT ==========

    @Test
    @DisplayName("Insert deve salvar e retornar ProdutoDTO")
    public void insertDeveSalvarERetornarProdutoDTO() {
        ProdutoDTO resultado = prodServ.insert(produtoDTO);

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals("Iphone", resultado.getNome());
        
        Mockito.verify(prodRep).save(any(Produto.class));
        Mockito.verify(catServ, Mockito.atLeastOnce()).findOrFailById(anyLong());
    }


    // ========== TESTES DE UPDATE ==========

    @Test
    @DisplayName("Update deve atualizar e retornar ProdutoDTO quando ID existir")
    public void updateDeveAtualizarQuandoIdExistir() {
        ProdutoDTO resultado = prodServ.update(idExistente, produtoDTO);

        Assertions.assertNotNull(resultado);
        
        Mockito.verify(prodRep).findById(idExistente);
        Mockito.verify(prodRep).save(any(Produto.class));
        Mockito.verify(catServ, Mockito.atLeastOnce()).findOrFailById(anyLong());
    }


    @Test
    @DisplayName("Update deve lançar EntidadeNaoEncontradaException quando ID não existir")
    public void updateDeveLancarExcecaoQuandoIdNaoExistir() {
        Assertions.assertThrows(EntidadeNaoEncontradaException.class, () -> {
            prodServ.update(idInexistente, produtoDTO);
        });
        
        Mockito.verify(prodRep).findById(idInexistente);
        Mockito.verify(prodRep, Mockito.never()).save(any(Produto.class));
    }
}