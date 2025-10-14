package com.devsuperior.aula.services.exceptions;

public class EntidadeNaoEncontradaException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(String msg) {
		super(msg);
	}
	
	public EntidadeNaoEncontradaException(Long id) {
		this(String.format("Entidade deste id '%d' não encontrada. ", id));
	}
}
