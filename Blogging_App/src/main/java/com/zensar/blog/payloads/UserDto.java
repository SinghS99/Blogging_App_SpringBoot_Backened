package com.zensar.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class UserDto {
 
	
	private Integer id;
	@NotEmpty
	@Size(min =4,message="Username must be of min 4 character")
	private String name;
	
	
	@Email(message="Email is mandotory,please enter valid email address")
	private String email;
	
	@NotEmpty
	@Size(min=4,max=10,message="password must be of min 4 character or max 10 character")
	//@Pattern(regexp =String)
	private String password;
	
	@NotEmpty
	@Size(min=4,max=10)
	private String about;
}
