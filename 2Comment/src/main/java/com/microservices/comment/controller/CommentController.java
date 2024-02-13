package com.microservices.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.comment.entity.Comment;
import com.microservices.comment.service.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	//http://localhost:8082/api/comments
	@PostMapping
	public ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {
	  	Comment saveComment = commentService.saveComment(comment);
	  	return new ResponseEntity<Comment>(saveComment, HttpStatus.OK);
	}
	
	
	//http://localhost:8082/api/comments/{postId}
	@GetMapping("/{postId}")
	public List<Comment> getAllCommentsBypostId(@PathVariable String postId){
		List<Comment> comments = commentService.getAllCommentsBypostId(postId);
		return comments;
	}
}
