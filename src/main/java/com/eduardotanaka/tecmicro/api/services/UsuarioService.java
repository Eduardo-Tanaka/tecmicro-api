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
	 * @param int: id
	 * @return Usuario
	 */
	Optional<Usuario> buscarPorId(int id);
}
