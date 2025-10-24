package com.devsuperior.aula.dto;

public class UsuarioInsertDTO extends UsuarioDTO {

	private static final long serialVersionUID = 1L;
	
	private String senha;
	
	public UsuarioInsertDTO() {
		super();
	}

	public UsuarioInsertDTO(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	

}
