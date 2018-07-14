package com.eduardotanaka.tecmicro.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardotanaka.tecmicro.api.entities.Post;
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
	public Optional<Post> buscarPorId(long id) {
		log.info("Buscando pelo id: {}", id);
		return Optional.ofNullable(this.postRepository.findById(id).get());
	}


}
