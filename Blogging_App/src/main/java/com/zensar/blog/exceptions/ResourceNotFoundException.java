package com.zensar.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
	

	String resourceName;
	String fieldsName;
	long fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldsName, long fieldValue) {
		super(String.format("%s not found with %s :%s",resourceName,fieldsName,fieldValue));
		this.resourceName = resourceName;
		this.fieldsName = fieldsName;
		this.fieldValue = fieldValue;
	}
	

}
