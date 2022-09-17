package com.digitalBook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalBook.entity.ERole;
import com.digitalBook.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>{

	Optional<Role> findByName(ERole name);
	}


