package com.digitalBook.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor


@Entity
@Table(name = "user_roles")

public class UserRole {
	@Id
	private long user_id;
	private long role_id;

}
