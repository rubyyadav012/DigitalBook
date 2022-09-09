package com.digitalBook.serviceImpl;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.digitalBook.Constants.DigitalBookConstant;
import com.digitalBook.bookService.UserService1;
import com.digitalBook.entity.User;
import com.digitalBook.repository.UserRepo1;
import com.digitalBook.utils.DigitalBookUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class UserServiceImpl implements UserService1{
	
	@Autowired
	UserRepo1 userRepo1;

	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		log.info("inside signup{}",requestMap);
		
		try {
		if(validateSignUpMap(requestMap)) {
			User user=userRepo1.findByEmail(requestMap.get("email"));
			if(Objects.isNull(user)) {
				userRepo1.save(getUserFromMap(requestMap));
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
}
