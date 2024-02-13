package com.microservices.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.post.entity.Post;

public interface PostRepo extends JpaRepository<Post, String> {

}
