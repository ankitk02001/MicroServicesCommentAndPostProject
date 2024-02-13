package com.microservices.post.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="posts")
@Entity
public class Post {

	@Id
	private String id;
	private String title;
	private String description;
	private String content;
	
	//8810355154
}
