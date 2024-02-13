package com.microservices.post.payload;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
//post entity
	private String id;
	private String title;
	private String description;
	private String content;
	
//comment Entity
	List<Comment> comments;
	
}
