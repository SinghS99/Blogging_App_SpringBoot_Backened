package com.zensar.blog.payloads;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	
	@NotEmpty
	@Size(min=4,max =100,message="Please enter title")
	private String  title;
	
	@NotEmpty(message="please enter content")
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto category;
	private UserDto user;

}
