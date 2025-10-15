package com.devsuperior.aula.factory;

import java.time.Instant;

import com.devsuperior.aula.dto.ProdutoDTO;
import com.devsuperior.aula.entities.Categoria;
import com.devsuperior.aula.entities.Produto;

public class ProdutoFactory {

	public static Produto criaProduto() {
		Produto produto = new Produto
			(1L, "Iphone", "Bom fone", 1900.9,
					"https://image4.ccom/img.png",
					Instant.parse("2020-10-14T10:37:30.00Z"));
		
		produto.getCategorias().add(new Categoria(1L, "Eletronicos"));
		return produto;
	}
	
	
	public static ProdutoDTO criaProdutoDTO() {
		Produto produto = criaProduto();
		return new ProdutoDTO(produto, produto.getCategorias());
		
	}
}
