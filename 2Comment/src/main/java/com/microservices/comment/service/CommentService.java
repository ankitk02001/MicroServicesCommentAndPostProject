package com.microservices.comment.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.comment.config.RestTemplateConfig;
import com.microservices.comment.entity.Comment;
import com.microservices.comment.payload.Post;
import com.microservices.comment.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private RestTemplateConfig restTemplate;

	public Comment saveComment(Comment comment) {
		// we have to check post exist or not before saving comment
		Post post = restTemplate.getRestTemplate()
				.getForObject("http://POST-SERVICE/api/posts/" + comment.getPostId(), Post.class);
		if (post != null) {
			
			String commentId = UUID.randomUUID().toString();
			comment.setCommentId(commentId);
			Comment savedComment = commentRepository.save(comment);
			return savedComment;
		} else {
			return null;
		}
	}

	public List<Comment> getAllCommentsBypostId(String postId) {
		List<Comment> comments = commentRepository.findByPostId(postId);
		return comments;
	}
}
