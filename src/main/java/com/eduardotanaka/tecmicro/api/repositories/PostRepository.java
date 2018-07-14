package com.eduardotanaka.tecmicro.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardotanaka.tecmicro.api.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
