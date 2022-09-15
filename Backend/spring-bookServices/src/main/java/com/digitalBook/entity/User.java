/*package com.digitalBook.entity;
import java.io.Serializable;
import javax.persistence.*;
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
public class User implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@NotBlank(message = "Username must not be empty")
	private String username;
	
	@NotBlank(message = "Password must not be empty")
	private String password;
	
	
	@NotBlank(message = "Email must be mentioned")
	private String email;
	
	private boolean loggedIn;
	
	//@NotBlank(message = "Role must be either Reader/Author")
	@Column(name="role")
	private String userrole;
	
	private boolean status;

	
}*/