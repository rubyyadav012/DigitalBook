package com.digitalBook.entity;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
    public class User1{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;
	

	//@ManyToMany(fetch = FetchType.LAZY)
	//@JoinTable(	name = "user_roles", 
				//joinColumns = @JoinColumn(name = "user_id"), 
	
	//inverseJoinColumns = @JoinColumn(name = "role_id"))
	@JsonIgnore
	@Transient
	private Set<Role> roles = new HashSet<>();
	
	
	private ERole role;

	 
	
public User1(String username, String email, String password,ERole role) {
	this.username = username;
	this.email = email;
	this.password = password;
	this.role=role;
}
}

	
