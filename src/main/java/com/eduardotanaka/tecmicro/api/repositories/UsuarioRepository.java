package com.eduardotanaka.tecmicro.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardotanaka.tecmicro.api.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
