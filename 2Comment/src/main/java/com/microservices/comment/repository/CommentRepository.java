package com.microservices.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, String> {
  
	public List<Comment> findByPostId(String postId);
}
