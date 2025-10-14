package com.devsuperior.aula.services.exceptions;

public class EntidadeEmUsoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
    public EntidadeEmUsoException(String msg) {
    	super(msg);
    }
    
    public EntidadeEmUsoException(Long id) {
		this(String.format("Entidade deste id '%d' está em uso. ", id));
	}
}


