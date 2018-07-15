package com.eduardotanaka.tecmicro.api.controllers;

import java.util.Calendar;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardotanaka.tecmicro.api.dtos.PostSaveDto;
import com.eduardotanaka.tecmicro.api.entities.Post;
import com.eduardotanaka.tecmicro.api.entities.Usuario;
import com.eduardotanaka.tecmicro.api.response.Response;
import com.eduardotanaka.tecmicro.api.services.PostService;
import com.eduardotanaka.tecmicro.api.services.UsuarioService;

@RestController
@RequestMapping("/api/post")
@CrossOrigin(origins = "*")
public class PostController {

	private static final Logger log = LoggerFactory.getLogger(PostController.class);
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public PostController() {}
	
	@PostMapping
	public ResponseEntity<Response<PostSaveDto>> cadastrarPost(@Valid @RequestBody PostSaveDto postDto, BindingResult result) {
		log.info("Cadastrando post: {}", postDto.toString());
		Response<PostSaveDto> response = new Response<PostSaveDto>();
		
		validarDados(postDto, result);
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
	
	private void validarDados(PostSaveDto post, BindingResult result) {
		boolean usuario = this.usuarioService.buscarPorId(post.getIdUsuario()).isPresent();
		if (!usuario) {
			result.addError(new ObjectError("usuario", "O usuário: " + post.getIdUsuario() + " não está cadastrado"));
		}
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
