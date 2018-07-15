package com.eduardotanaka.tecmicro.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardotanaka.tecmicro.api.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	Optional<List<Post>> findByUsuarioId(Long id);
}
