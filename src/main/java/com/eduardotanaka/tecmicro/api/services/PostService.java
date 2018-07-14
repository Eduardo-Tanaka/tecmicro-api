package com.eduardotanaka.tecmicro.api.services;

import java.util.Optional;

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
	 * @param long: id
	 * @return Post
	 */
	Optional<Post> buscarPorId(long id);
}
