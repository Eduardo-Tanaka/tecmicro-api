package com.eduardotanaka.tecmicro.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardotanaka.tecmicro.api.entities.Post;
import com.eduardotanaka.tecmicro.api.exceptions.ObjectNotFoundException;
import com.eduardotanaka.tecmicro.api.repositories.PostRepository;
import com.eduardotanaka.tecmicro.api.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	private static final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);

	@Autowired
	PostRepository postRepository;
	
	@Override
	public Post salvar(Post post) {
		log.info("Salvando post: {}", post);
		return this.postRepository.save(post);
	}

	@Override
	public Post buscarPorId(Long id) {
		log.info("Buscando pelo id: {}", id);
		Optional<Post> post =  this.postRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + id 
				+ ", Tipo: " + PostServiceImpl.class.getName()));
	}

	@Override
	public List<Post> buscarPorIdUsuario(Long id) {
		log.info("Buscando pelo id do usuário: {}", id);
		return this.postRepository.findByUsuarioId(id).orElseThrow(() -> new ObjectNotFoundException(
				"Usuário não encontrado. Id: " + id + ", Tipo: " + PostServiceImpl.class.getName()));
	}

	@Override
	public List<Post> buscarTodos() {
		log.info("Buscando todos os posts");
		return this.postRepository.findAll();
	}

}
