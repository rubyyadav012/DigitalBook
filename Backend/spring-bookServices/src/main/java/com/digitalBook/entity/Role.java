package com.digitalBook.entity;
import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;




@Data
@Setter
@Getter

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;
	
	public Role() {

	}
}

	