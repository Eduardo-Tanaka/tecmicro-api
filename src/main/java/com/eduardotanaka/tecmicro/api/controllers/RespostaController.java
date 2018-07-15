package com.eduardotanaka.tecmicro.api.controllers;

import java.util.Calendar;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardotanaka.tecmicro.api.dtos.RespostaSaveDto;
import com.eduardotanaka.tecmicro.api.entities.Post;
import com.eduardotanaka.tecmicro.api.entities.Resposta;
import com.eduardotanaka.tecmicro.api.entities.Usuario;
import com.eduardotanaka.tecmicro.api.response.Response;
import com.eduardotanaka.tecmicro.api.services.RespostaService;

@RestController
@RequestMapping("/api/resposta")
@CrossOrigin(origins = "*")
public class RespostaController {

	private static final Logger log = LoggerFactory.getLogger(RespostaController.class);
	
	@Autowired
	private RespostaService respostaService;
	
	public RespostaController() {}
	
	@PostMapping
	public ResponseEntity<Response<RespostaSaveDto>> cadastrarPost(@Valid @RequestBody RespostaSaveDto respostaDto, BindingResult result) {
		log.info("Cadastrando post: {}", respostaDto.toString());
		Response<RespostaSaveDto> response = new Response<RespostaSaveDto>();
		
		Resposta resposta = this.converterDto(respostaDto);
		
		if (result.hasErrors()) {
			log.error("Erro ao validar resposta: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Resposta r = this.respostaService.salvar(resposta);
		respostaDto.setId(r.getId());
		
		response.setData(respostaDto);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Converte os dados do DTO para Resposta
	 * 
	 * @param RespostaSaveDto
	 * @return Resposta
	 */
	private Resposta converterDto(RespostaSaveDto dto) {
		Resposta resposta = new Resposta();
		resposta.setDataAtualizacao(Calendar.getInstance());
		resposta.setDataCriacao(Calendar.getInstance());
		resposta.setContent(dto.getContent());
		
		Usuario usuario = new Usuario();
		usuario.setId(dto.getIdUsuario());
		resposta.setUsuario(usuario);
		
		Post post = new Post();
		post.setId(dto.getIdPost());
		resposta.setPost(post);
		
		return resposta;
	}

}
