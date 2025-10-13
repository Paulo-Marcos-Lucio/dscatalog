package com.devsuperior.aula.services;

public class EntidadeNaoEncontradaException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(String msg) {
		super(msg);
	}
}
