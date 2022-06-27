package com.zensar.blog.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="categories")
@Getter
@Setter
@NoArgsConstructor
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer CategoryId;
	
	@Column(name="title")
	private String CategoryTitle;
	
	@Column(name="description")
	private String CategoryDescription;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Post> posts=new ArrayList<Post>();
	
}
