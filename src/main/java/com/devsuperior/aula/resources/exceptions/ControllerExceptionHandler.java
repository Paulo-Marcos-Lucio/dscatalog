package com.devsuperior.aula.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.aula.services.exceptions.EntidadeEmUsoException;
import com.devsuperior.aula.services.exceptions.EntidadeNaoEncontradaException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<ErroPadrao> entidadeNaoEncontrada(EntidadeNaoEncontradaException ex,
					HttpServletRequest request) {
		
		ErroPadrao erro = new ErroPadrao();
		erro.setTimestamp(Instant.now());
		erro.setStatus(HttpStatus.NOT_FOUND.value());
		erro.setError("Recurso não encontrado.");
		erro.setMessage("Não foi possivel encontrar uma categoria deste id");
		erro.setPath(request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	
	@ExceptionHandler(EntidadeEmUsoException.class)
	public ResponseEntity<ErroPadrao> entidadeEmUso(EntidadeEmUsoException ex, HttpServletRequest request) {
		ErroPadrao erro = new ErroPadrao();
		erro.setTimestamp(Instant.now());
		erro.setStatus(HttpStatus.CONFLICT.value());
		erro.setError("Recurso em uso.");
		erro.setMessage("Este recurso está em uso como dependencia externa de outro recurso.");
		erro.setPath(request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
}
