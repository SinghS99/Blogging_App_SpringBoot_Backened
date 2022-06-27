package com.zensar.blog.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
	
	
	private Integer CategoryId;
	@NotEmpty(message="Please Enter the Title")
	private String CategoryTitle;
	@NotEmpty
	@Size(min=5,max=50)
	private String CategoryDescription;

}
