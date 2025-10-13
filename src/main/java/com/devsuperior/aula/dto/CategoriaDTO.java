package com.devsuperior.aula.dto;

import java.io.Serializable;
import java.util.Objects;

import com.devsuperior.aula.entities.Categoria;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	
	
	
	public CategoriaDTO() {
		
	}

	public CategoriaDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public CategoriaDTO(Categoria entidade) {
		this.id = entidade.getId();
		this.nome = entidade.getNome();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	
}
