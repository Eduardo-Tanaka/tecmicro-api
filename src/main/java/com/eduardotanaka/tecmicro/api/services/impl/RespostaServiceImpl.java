package com.eduardotanaka.tecmicro.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardotanaka.tecmicro.api.entities.Resposta;
import com.eduardotanaka.tecmicro.api.repositories.RespostaRepository;
import com.eduardotanaka.tecmicro.api.services.RespostaService;

@Service
public class RespostaServiceImpl implements RespostaService {

	private static final Logger log = LoggerFactory.getLogger(RespostaServiceImpl.class);

	@Autowired
	RespostaRepository respostaRepository;
	
	@Override
	public Resposta salvar(Resposta resposta) {
		log.info("Salvando resposta: {}", resposta);
		return this.respostaRepository.save(resposta);
	}

}
