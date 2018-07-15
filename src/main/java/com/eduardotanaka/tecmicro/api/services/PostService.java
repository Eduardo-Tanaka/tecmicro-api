package com.eduardotanaka.tecmicro.api.services;

import java.util.List;

import com.eduardotanaka.tecmicro.api.entities.Post;

public interface PostService {

	/**
	 * Persiste um post no banco de dados
	 * @param Post: post
	 * @return Post
	 */
	Post salvar(Post post);
	
	/**
	 * Busca e retorna um post pelo id
	 * @param Long: id
	 * @return Post
	 */
	Post buscarPorId(Long id);
	
	/**
	 * Busca e retorna uma lista de posts pelo id do usuario
	 * @param Long: id
	 * @return List<Post>
	 */
	List<Post> buscarPorIdUsuario(Long id);
	
	/**
	 * Busca e retorna todos os posts
	 * @return List<Post>
	 */
	List<Post> buscarTodos();
}
