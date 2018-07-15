package com.eduardotanaka.tecmicro.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardotanaka.tecmicro.api.entities.Usuario;
import com.eduardotanaka.tecmicro.api.exceptions.ObjectNotFoundException;
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
		if (buscarPorMatricula(usuario.getMatricula())) {
			throw new ObjectNotFoundException("Usuário já cadastrado. Matrícula: " + usuario.getMatricula() + ", Tipo: " + PostServiceImpl.class.getName());
		}
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public Usuario buscarPorId(Long id) {
		return this.usuarioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Usuário não encontrado. Id: " + id + ", Tipo: " + PostServiceImpl.class.getName()));
	}

	@Override
	public boolean buscarPorMatricula(int matricula) {
		return this.usuarioRepository.findByMatricula(matricula).isPresent();
	}

}
