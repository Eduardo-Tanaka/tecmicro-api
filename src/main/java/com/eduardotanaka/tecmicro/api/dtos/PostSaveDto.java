package com.eduardotanaka.tecmicro.api.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PostSaveDto {

	private Long id;
	
	@NotEmpty(message = "O campo título não pode ser vazio")
	@Size(max = 255, message = "O título deve ter no máximo 255 caracteres")
	private String title;
	
	@NotEmpty(message = "O campo descrição não pode ser vazio")
	@Size(max = 1000, message = "A descrição deve ter no máximo 1000 caracteres")
	private String content;
	
	private Long idUsuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	@Override
	public String toString() {
		return "PostSaveDto [id=" + id + ", title=" + title + ", content=" + content + ", idUsuario=" + idUsuario + "]";
	}

}
