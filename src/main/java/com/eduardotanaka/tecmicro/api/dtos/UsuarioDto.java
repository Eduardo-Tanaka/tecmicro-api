package com.eduardotanaka.tecmicro.api.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UsuarioDto {

	private Long id;
	
	@NotNull(message = "O campo matrícula não pode ser vazio")
	private int matricula;
	
	@NotEmpty(message = "O campo nome não pode ser vazio")
	@Length(max = 255, message = "O nome deve ter no máximo 255 caracteres")
	private String nome;
	
	//private byte[] foto;
	
	public UsuarioDto() {}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/*public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}*/

	@Override
	public String toString() {
		return "UsuarioDto [id=" + id + ", nome=" + nome + ", foto=" + ", matricula=" + matricula + "]";
	}
}
