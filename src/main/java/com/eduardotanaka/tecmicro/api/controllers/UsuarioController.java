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

import com.eduardotanaka.tecmicro.api.dtos.UsuarioDto;
import com.eduardotanaka.tecmicro.api.entities.Usuario;
import com.eduardotanaka.tecmicro.api.response.Response;
import com.eduardotanaka.tecmicro.api.services.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	public UsuarioController() {}
	
	@PostMapping
	public ResponseEntity<Response<UsuarioDto>> cadastrarUsuario(@Valid @RequestBody UsuarioDto usuarioDto, BindingResult result) {
		log.info("Cadastrando usuário: {}", usuarioDto.toString());
		Response<UsuarioDto> response = new Response<UsuarioDto>();
		
		validarDados(usuarioDto, result);
		Usuario usuario = this.converterDto(usuarioDto);
		
		if (result.hasErrors()) {
			log.error("Erro ao validar usuario: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		this.usuarioService.salvar(usuario);
		
		response.setData(usuarioDto);
		return ResponseEntity.ok(response);
	}
	
	private void validarDados(UsuarioDto usuario, BindingResult result) {
		this.usuarioService.buscarPorMatricula(usuario.getMatricula())
			.ifPresent(user -> result.addError(new ObjectError("usuario", "A matrícula: " + usuario.getMatricula() + " já está cadastrada")));
	}
	
	/**
	 * Converte os dados do DTO para Usuario
	 * 
	 * @param UsuarioDto
	 * @return Usuario
	 */
	private Usuario converterDto(UsuarioDto dto) {
		Usuario usuario = new Usuario();
		usuario.setDataAtualizacao(Calendar.getInstance());
		usuario.setDataCriacao(Calendar.getInstance());
		usuario.setNome(dto.getNome());
		usuario.setMatricula(dto.getMatricula());
		usuario.setId(null);
		
		return usuario;
	}
}
