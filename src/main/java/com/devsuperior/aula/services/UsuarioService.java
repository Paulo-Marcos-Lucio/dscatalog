package com.devsuperior.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.aula.dto.PapelDTO;
import com.devsuperior.aula.dto.UsuarioDTO;
import com.devsuperior.aula.dto.UsuarioInsertDTO;
import com.devsuperior.aula.entities.Papel;
import com.devsuperior.aula.entities.Usuario;
import com.devsuperior.aula.repositories.UsuarioRepository;
import com.devsuperior.aula.services.exceptions.EntidadeEmUsoException;
import com.devsuperior.aula.services.exceptions.EntidadeNaoEncontradaException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usrRep;
	
	@Autowired
	private PapelService papelServ;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	
	@Transactional(readOnly = true)
	public Page<UsuarioDTO> findAllPaged(Pageable pageable) {
		Page<Usuario> usuarios = usrRep.findAll(pageable);
	
		return usuarios
			.map(usuarioBd -> new UsuarioDTO(usuarioBd));
	}
	
	
	@Transactional(readOnly = true)
	public UsuarioDTO findById(Long id) {
		Usuario usuario = findOrFailById(id);
		
		return new UsuarioDTO(usuario);
	}
	
	
	public Usuario findOrFailById(Long id) {
		return usrRep.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(id));
	}
	
	
	@Transactional
	public UsuarioDTO insert(UsuarioInsertDTO usuarioDTO) {
		Usuario usuarioBD = new Usuario();
		copyDtoToEntity(usuarioDTO, usuarioBD);
		usuarioBD.setSenha(encoder.encode(usuarioDTO.getSenha()));
		usuarioBD = usrRep.save(usuarioBD);
		return new UsuarioDTO(usuarioBD);
	}
	
	
	@Transactional
	public void delete(Long id) {
		findOrFailById(id);
		try {
			usrRep.deleteById(id);
			usrRep.flush();
		}
		catch(DataIntegrityViolationException ex) {
			throw new EntidadeEmUsoException(id);
		}
	}
	
	
	@Transactional
	public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO) {
		Usuario usuarioBD = findOrFailById(id);
		copyDtoToEntity(usuarioDTO, usuarioBD);
		usuarioBD = usrRep.save(usuarioBD);
		return new UsuarioDTO(usuarioBD);
	}
	
	
	
	private void copyDtoToEntity(UsuarioDTO usuarioDTO, Usuario usuarioBD) {
		usuarioBD.setPrimeiroNome(usuarioDTO.getPrimeiroNome());
		usuarioBD.setUltimoNome(usuarioDTO.getUltimoNome());
		usuarioBD.setEmail(usuarioDTO.getEmail());
	
		
		usuarioBD.getPapeis().clear();
		
		for(PapelDTO papelDTO : usuarioDTO.getPapeis()) {
			Papel papelBD = papelServ.findOrFailById(papelDTO.getId());
			usuarioBD.getPapeis().add(papelBD);
		}
	}
	
	
	
	
	
	
}
