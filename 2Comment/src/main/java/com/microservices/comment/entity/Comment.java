package com.microservices.comment.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="comments")
public class Comment {

	@Id
	private String commentId;
	private String name;
	private String email;
	private String body;
	private String postId;//this should be come  from Post postId
}
