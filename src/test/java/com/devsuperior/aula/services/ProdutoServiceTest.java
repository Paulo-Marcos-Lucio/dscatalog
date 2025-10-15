package com.devsuperior.aula.services;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.devsuperior.aula.repositories.ProdutoRepository;

@ExtendWith(SpringExtension.class)
public class ProdutoServiceTest {

	@InjectMocks
	private ProdutoService prodServ;
	
	@Mock
	private ProdutoRepository prodRep;
	
	
}
