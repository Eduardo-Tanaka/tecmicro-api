package com.eduardotanaka.tecmicro.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.eduardotanaka.tecmicro.api.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Transactional(readOnly = true)
	Usuario findByMatricula(int matricula);
}
