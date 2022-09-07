package com.digitalBook.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter

@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = { "id", "email" })

})

public class Reader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotBlank(message = "Username must not be empty")
	private String username;
	@NotBlank(message = "Password must not be empty")
	private String password;
	@NotBlank(message = "Email must not be empty")
	private String email;
	
}

	

