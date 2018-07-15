package com.eduardotanaka.tecmicro.api.services;

import com.eduardotanaka.tecmicro.api.entities.Resposta;

public interface RespostaService  {

	/**
	 * Persiste uma resposta em um post no banco de dados
	 * @param Resposta: resposta
	 * @return Resposta
	 */
	Resposta salvar(Resposta resposta);
	
}
