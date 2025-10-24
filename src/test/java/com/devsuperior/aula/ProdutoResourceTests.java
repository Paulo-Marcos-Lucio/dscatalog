package com.devsuperior.aula;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.devsuperior.aula.dto.ProdutoDTO;
import com.devsuperior.aula.factory.ProdutoFactory;
import com.devsuperior.aula.resources.ProdutoResource;
import com.devsuperior.aula.services.ProdutoService;
import com.devsuperior.aula.services.exceptions.EntidadeNaoEncontradaException;

@WebMvcTest(ProdutoResource.class)
public class ProdutoResourceTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProdutoService prodServ;
	
	private ProdutoDTO produtoDTO;
	private PageImpl<ProdutoDTO> page;
	private Long idExistente;
	private Long idInexistente;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		
		produtoDTO = ProdutoFactory.criaProdutoDTO();
		page = new PageImpl<>(List.of(produtoDTO));
		idExistente = 1L;
		idInexistente = 999L;
		
		Mockito.when(prodServ.findAllPaged(any())).thenReturn(page);
		
		Mockito.when(prodServ.findById(idExistente))
				.thenReturn(produtoDTO);
		
		Mockito.when(prodServ.findById(idInexistente))
				.thenThrow(EntidadeNaoEncontradaException.class);
	}
	
	
	
	@Test
	public void findAllDeveRetornarListaPageProdutos() throws Exception {
		mockMvc.perform(get("/produtos")).andExpect(status().isOk());
	}
	
	
	@Test
	public void findByIdDeveRetornarProdutoDTOQuandoIdExistir() throws Exception {
		ResultActions result =
				mockMvc.perform
						(get("/produtos/{idExistente}", idExistente));
				    
		
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.id").exists());
		result.andExpect(jsonPath("$.nome").exists());
		result.andExpect(jsonPath("$.descricao").exists());
	}
	
	
	@Test
	public void findByIdDeveLancarExcecaoQuandoIdInexistente() throws Exception {
		ResultActions result =
				mockMvc.perform(get("/produtos/{idInexistente}", idInexistente));
		
		result.andExpect(status().isNotFound());
	}
	
	
	
	
	
	
	
	
	
}
