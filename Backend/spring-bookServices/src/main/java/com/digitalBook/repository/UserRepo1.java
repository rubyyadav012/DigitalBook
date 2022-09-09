package com.digitalBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.digitalBook.entity.User;

public interface UserRepo1 extends JpaRepository<User,Integer> {
	
	User findByEmail(@Param("email") String email);

}
