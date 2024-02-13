package com.microservices.post.service;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.post.config.RestTemplateConfig;
import com.microservices.post.entity.Post;
import com.microservices.post.payload.PostDto;
import com.microservices.post.repository.PostRepo;

@Service
public class PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private RestTemplateConfig restTemplate;
	
	public Post savePost(Post post) {
	String postId = UUID.randomUUID().toString();//setting the value to post automatically
	post.setId(postId);
	return	postRepo.save(post);
	}

	public Post findPostById(String postId) {
	Post post = postRepo.findById(postId).get();
	return post;
	}

	public PostDto getPostWithComments(String postId) {
		  ArrayList comments = restTemplate.getRestTemplate()
				.getForObject("http://COMMENT-SERVICE/api/comments/"+postId,  ArrayList.class);
		
		Post post = postRepo.findById(postId).get();
		//putting them into postDto
		PostDto postDto = new PostDto();
		postDto.setId(post.getId());
		postDto.setTitle(post.getTitle());
		postDto.setDescription(post.getDescription());
		postDto.setContent(post.getContent());
		postDto.setComments(comments);//setting comments
		return postDto;
	}

}
