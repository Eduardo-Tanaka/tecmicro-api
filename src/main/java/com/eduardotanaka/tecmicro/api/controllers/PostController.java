package com.eduardotanaka.tecmicro.api.controllers;

import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardotanaka.tecmicro.api.dtos.PostSaveDto;
import com.eduardotanaka.tecmicro.api.entities.Post;
import com.eduardotanaka.tecmicro.api.entities.Usuario;
import com.eduardotanaka.tecmicro.api.response.Response;
import com.eduardotanaka.tecmicro.api.services.PostService;

@RestController
@RequestMapping("/api/post")
@CrossOrigin(origins = "*")
public class PostController {

	private static final Logger log = LoggerFactory.getLogger(PostController.class);
	
	@Autowired
	private PostService postService;
	
	public PostController() {}
	
	@PostMapping
	public ResponseEntity<Response<PostSaveDto>> cadastrarPost(@Valid @RequestBody PostSaveDto postDto, BindingResult result) {
		log.info("Cadastrando post: {}", postDto.toString());
		Response<PostSaveDto> response = new Response<PostSaveDto>();
		
		Post post = this.converterDto(postDto);
		
		if (result.hasErrors()) {
			log.error("Erro ao validar post: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Post p = this.postService.salvar(post);
		postDto.setId(p.getId());
		postDto.setIdUsuario(p.getUsuario().getId());
		
		response.setData(postDto);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> post(@PathVariable Long id) {
		log.info("Buscando post: {}", id);
		
		Post post = this.postService.buscarPorId(id);
		
		return ResponseEntity.ok(post);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<List<Post>> todosPosts() {
		log.info("Buscando todos posts");
		
		List<Post> posts = this.postService.buscarTodos();
		
		return ResponseEntity.ok(posts);
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<List<Post>> postByUsuario(@PathVariable Long id) {
		log.info("Buscando posts pelo usuário: {}", id);
		
		List<Post> lista = this.postService.buscarPorIdUsuario(id);

		return ResponseEntity.ok(lista);
	}

	/**
	 * Converte os dados do DTO para Post
	 * 
	 * @param PostSaveDto
	 * @return Post
	 */
	private Post converterDto(PostSaveDto dto) {
		Post post = new Post();
		post.setDataAtualizacao(Calendar.getInstance());
		post.setDataCriacao(Calendar.getInstance());
		post.setTitle(dto.getTitle());
		post.setContent(dto.getContent());
		
		Usuario usuario = new Usuario();
		usuario.setId(dto.getIdUsuario());
		post.setUsuario(usuario);
		
		return post;
	}
}
