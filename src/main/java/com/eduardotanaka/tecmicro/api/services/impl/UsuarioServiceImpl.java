package com.eduardotanaka.tecmicro.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardotanaka.tecmicro.api.entities.Usuario;
import com.eduardotanaka.tecmicro.api.repositories.UsuarioRepository;
import com.eduardotanaka.tecmicro.api.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario salvar(Usuario usuario) {
		log.info("Salvando usuário: {}", usuario);
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public Optional<Usuario> buscarPorId(Long id) {
		return this.usuarioRepository.findById(id);
	}
	
	@Override
	public Optional<Usuario> buscarPorMatricula(int matricula) {
		return Optional.ofNullable(this.usuarioRepository.findByMatricula(matricula));
	}

}
