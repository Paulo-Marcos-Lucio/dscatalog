package com.devsuperior.aula.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.devsuperior.aula.entities.Usuario;

public class UsuarioDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String primeiroNome;
	private String ultimoNome;
	private String email;

	
	Set<PapelDTO> papeis = new HashSet<>();
	
	
	public UsuarioDTO() {
		
	}

	public UsuarioDTO(Long id, String primeiroNome, String ultimoNome, String email) {
		this.id = id;
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.email = email;
	}

	public UsuarioDTO(Usuario entity) {
		id = entity.getId();
		primeiroNome = entity.getPrimeiroNome();
		ultimoNome = entity.getUltimoNome();
		email = entity.getEmail();
		entity.getPapeis().forEach
		(papelBD -> this.papeis.add(new PapelDTO(papelBD)));
		
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<PapelDTO> getPapeis() {
		return papeis;
	}
	
	
}
