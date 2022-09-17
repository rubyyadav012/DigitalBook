package com.digitalBook.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.digitalBook.entity.User1;

public interface UserRepo extends JpaRepository<User1,Integer> {
	
		public User1 findByEmail(@Param("email") String email);
		Optional<User1> findByUsername(String username);
		Boolean existsByUsername(String username);

		Boolean existsByEmail(String email);


	

	

}
