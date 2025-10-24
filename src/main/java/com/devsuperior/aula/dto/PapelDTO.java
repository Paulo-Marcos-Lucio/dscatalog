package com.devsuperior.aula.dto;

import java.io.Serializable;
import java.util.Objects;

import com.devsuperior.aula.entities.Papel;

public class PapelDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String autoridade;
	
	
	public PapelDTO() {
		
	}
	
	public PapelDTO(Long id, String autoridade) {
		this.id = id;
		this.autoridade = autoridade;
	}
	
	public PapelDTO(Papel entity) {
		id = entity.getId();
		autoridade = entity.getAutoridade();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutoridade() {
		return autoridade;
	}

	public void setAutoridade(String autoridade) {
		this.autoridade = autoridade;
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
		PapelDTO other = (PapelDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
