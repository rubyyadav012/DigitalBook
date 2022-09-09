package com.digitalBook.controllerImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.digitalBook.bookService.UserService1;
import com.digitalBook.controller.UserController1;
import com.digitalBook.utils.DigitalBookUtils;
import com.digitalBook.Constants.*;

@RestController
public class UserControllerImpl implements UserController1 {

	@Autowired
	UserService1 userSerive1;
	
	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		
		try {
		// TODO Auto-generated method stub
		return userSerive1.signUp(requestMap);
	}
		catch(Exception ex) {
			ex.printStackTrace();
		}
    return DigitalBookUtils.getResponseEntity(DigitalBookConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
}
}