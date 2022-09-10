package com.digitalBook.controllerImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.digitalBook.bookService.UserService;
import com.digitalBook.constants.*;
import com.digitalBook.controller.UserController;
import com.digitalBook.utils.DigitalBookUtils;

@RestController
public class UserControllerImpl implements UserController {

	@Autowired
	UserService userSerive;
	
	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		
		try {
		// TODO Auto-generated method stub
		return userSerive.signUp(requestMap);
	}
		catch(Exception ex) {
			ex.printStackTrace();
		}
    return DigitalBookUtils.getResponseEntity(DigitalBookConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
}

	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		try {
		return userSerive.login(requestMap);
		// TODO Auto-generated method stub
	
	}catch(Exception ex) {
	System.out.println(ex.getStackTrace());
	}
	    
	 return DigitalBookUtils.getResponseEntity(DigitalBookConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}