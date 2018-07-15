package com.eduardotanaka.tecmicro.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardotanaka.tecmicro.api.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
