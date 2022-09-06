package com.digitalBook.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data

@Entity
public class Author {
	
	@Id
	@Column(name="author_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int author_id;
	
	//@NotBlank(message="please Enter Author name")
	private String name;
	
	private String Password;

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
	
}
