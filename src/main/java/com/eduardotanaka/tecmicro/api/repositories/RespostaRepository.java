package com.eduardotanaka.tecmicro.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardotanaka.tecmicro.api.entities.Resposta;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long>{

}
