package com.microservices.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.post.entity.Post;
import com.microservices.post.payload.PostDto;
import com.microservices.post.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	private PostService postService;

	@PostMapping
	public ResponseEntity<Post> savePost(@RequestBody Post post){
		Post savePost = postService.savePost(post);
		return new ResponseEntity<>(savePost, HttpStatus.CREATED);
	}
	
	
	//http://localhost:8081/api/posts/{postId}
	@GetMapping("/{postId}")
	public Post getPostByPostId(@PathVariable String postId) {
	return	postService.findPostById(postId);
	}
	
	//http://localhost:8081/api/posts/{postId}/comments
	@GetMapping("{postId}/comments")
	public ResponseEntity<PostDto> getPostWithComments(@PathVariable String postId){
		PostDto postWithComments = postService.getPostWithComments(postId);
		return new ResponseEntity<PostDto>(postWithComments,HttpStatus.OK);
	}
	
	
	
}
