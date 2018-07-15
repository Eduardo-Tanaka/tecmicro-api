package com.eduardotanaka.tecmicro.api.services;

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
	 * @param Long: id
	 * @return Usuario
	 */
	Usuario buscarPorId(Long id);
	
	/**
	 * Busca e retorna um usuário pela matrícula
	 * @param int: matricula
	 * @return boolean
	 */
	boolean buscarPorMatricula(int matricula);
}
