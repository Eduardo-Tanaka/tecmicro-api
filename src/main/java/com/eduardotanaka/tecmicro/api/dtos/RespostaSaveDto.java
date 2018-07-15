package com.eduardotanaka.tecmicro.api.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RespostaSaveDto {

	private Long id;
	
	@NotEmpty(message = "O campo descrição não pode ser vazio")
	@Size(max = 1000, message = "A descrição deve ter no máximo 1000 caracteres")
	private String content;
	
	@NotNull(message = "O campo id do usuário não pode ser nulo")
	private Long idUsuario;
	
	@NotNull(message = "O campo id do post não pode ser nulo")
	private Long idPost;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdPost() {
		return idPost;
	}

	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}

	@Override
	public String toString() {
		return "RespostaSaveDto [id=" + id + ", content=" + content + ", idUsuario=" + idUsuario + ", idPost=" + idPost
				+ "]";
	}
	
}
