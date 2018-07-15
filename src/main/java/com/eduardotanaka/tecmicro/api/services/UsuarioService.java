package com.eduardotanaka.tecmicro.api.services;

import java.util.Optional;

import com.eduardotanaka.tecmicro.api.entities.Usuario;

public interface UsuarioService {

	/**
	 * Persiste um usuário no banco de dados
	 * @param Usuario: usuario
	 * @return Usuario
	 */
	Usuario salvar(Usuario usuario);
	
	/**
	 * Busca e retorna um usuário pelo id
	 * @param long: id
	 * @return Usuario
	 */
	Optional<Usuario> buscarPorId(Long id);
	
	/**
	 * Busca e retorna um post pelo id
	 * @param int: matricula
	 * @return Usuario
	 */
	Optional<Usuario> buscarPorMatricula(int matricula);
}
