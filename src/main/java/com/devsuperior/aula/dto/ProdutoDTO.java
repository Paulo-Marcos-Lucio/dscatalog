package com.devsuperior.aula.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.devsuperior.aula.entities.Categoria;
import com.devsuperior.aula.entities.Produto;

public class ProdutoDTO {

private Long id;
	
	private String nome;
	private String descricao;
	private Double preco;
	private String imgUrl;
	private Instant date;
	
	private List<CategoriaDTO> categorias = new ArrayList<>();
	
	
	
	public ProdutoDTO() {
		
	}
	
	
	public ProdutoDTO(Long id, String nome, String descricao, Double preco, String imgUrl, Instant date) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.imgUrl = imgUrl;
		this.date = date;
	}

	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		this.imgUrl = produto.getImgUrl();
		this.date = produto.getDate();
	}
	
	
	public ProdutoDTO(Produto produtoBD, Set<Categoria> categorias) {
		this(produtoBD);
		categorias.forEach(catBD -> this.categorias
					.add(new CategoriaDTO(catBD)));
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public Instant getDate() {
		return date;
	}


	public void setDate(Instant date) {
		this.date = date;
	}


	public Long getId() {
		return id;
	}


	public List<CategoriaDTO> getCategorias() {
		return categorias;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoDTO other = (ProdutoDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
