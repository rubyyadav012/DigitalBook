package com.digitalBook.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Setter
@Getter
@NoArgsConstructor


@Entity
@Table(name = "user")
public class User  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "Username must not be empty")
	private String username;
	
	@NotBlank(message = "Password must not be empty")
	private String password;
	
	@Email
	@NotBlank(message = "Email must be mentioned")
	private String email;
	
	@NotBlank(message = "Role must be either Reader/Author")
	private String userrole;

	
}