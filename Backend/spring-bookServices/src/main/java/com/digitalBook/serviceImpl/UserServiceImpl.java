package com.digitalBook.serviceImpl;

import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import com.digitalBook.bookService.UserService;
import com.digitalBook.constants.DigitalBookConstant;
import com.digitalBook.entity.User;
import com.digitalBook.repository.UserRepo;
import com.digitalBook.utils.DigitalBookUtils;
import lombok.extern.slf4j.Slf4j;
import com.digitalBook.jwt.CustomerUserDetailsService;
import com.digitalBook.jwt.JwtUtill;

@Slf4j
@Service

public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;

	
	@Autowired
	AuthenticationManager  authenticationManager;
	
	@Autowired
	CustomerUserDetailsService customerUserDetailsService;
	
	@Autowired
	JwtUtill jwtUtil;
	
	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		log.info("inside signup{}",requestMap);
		
		try {
		if(validateSignUpMap(requestMap)) {
			User user=userRepo.findByEmail(requestMap.get("email"));
			if(Objects.isNull(user)) {
				userRepo.save(getUserFromMap(requestMap));
				return DigitalBookUtils.getResponseEntity(DigitalBookConstant.SUCCESSFULLY_RESGISTER,HttpStatus.OK);
			}
			
			else {
				return DigitalBookUtils.getResponseEntity(DigitalBookConstant.USER_ALREADY_EXIST,HttpStatus.BAD_REQUEST);
			}
		
		}else {
			return DigitalBookUtils.getResponseEntity(DigitalBookConstant.INVALID_DATA,HttpStatus.BAD_REQUEST);
		}
	
	}catch (Exception ex) {
		ex.printStackTrace();
	}
		 return DigitalBookUtils.getResponseEntity(DigitalBookConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	private boolean validateSignUpMap(Map<String,String> requestMap) {
		
		if(requestMap.containsKey("username") && requestMap.containsKey("password")
				&& requestMap.containsKey("email")) {
			return true;
	}
		return false;
	
	}
	
	private User getUserFromMap(Map<String,String> requestMap) {
		User user=new User();
		user.setUsername("username");
		user.setPassword("password");
		user.setEmail("email");
		user.setUserrole("userrole");
		user.setLoggedIn(true);
		user.setStatus(true);
		user.setUserrole("user");
		return user;
	}


	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		log.info("Inside login");
		try {
		Authentication auth=authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(requestMap.get("email"),requestMap.get("password"))
				);
		if(auth.isAuthenticated()) {
			if(customerUserDetailsService.getUserDetails().isStatus()) {
				return new ResponseEntity<String>("{\"token\":\""+
			jwtUtil.generateToken(customerUserDetailsService. getUserDetails().getEmail(),
					customerUserDetailsService.getUserDetails().getUserrole()) +"\"}",HttpStatus.OK);
			}
		else {
			return new ResponseEntity<String>("{\"message\":"+"wait for admin approval"+"\"}",HttpStatus.BAD_REQUEST);
		}
		}
		
	}catch(Exception ex) {
		log.error("{}",ex);
	}
		return new ResponseEntity<String>("{\"message\":"+"wait for admin approval"+"\"}",HttpStatus.BAD_REQUEST);
	}
}

	
