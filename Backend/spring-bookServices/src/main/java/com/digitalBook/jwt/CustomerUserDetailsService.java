package com.digitalBook.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.digitalBook.exception.ResourceNotFoundException;
import com.digitalBook.repository.UserRepo;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@Service

public class CustomerUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepo userRepo;
	
	private com.digitalBook.entity.User userDetails;
	
	public UserDetails loadUserByUsername(String username) throws ResourceNotFoundException{
		log.info("Inside loadUserByUsername {}",username);
	
	userDetails=userRepo.findByEmail(username);
	
	if(!Objects.isNull(userDetails))
		
		return new User(userDetails.getEmail(),userDetails.getPassword(),new ArrayList<>());
	
	throw new ResourceNotFoundException("user not found");

}

  public com.digitalBook.entity.User getUserDetails(){

	return userDetails;
}
}