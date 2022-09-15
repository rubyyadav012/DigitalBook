/*package com.digitalBook.controllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.digitalBook.Utils.DigitalBooksUtils;
import com.digitalBook.bookService.UserService;
import com.digitalBook.constants.*;
import com.digitalBook.controller.UserController;
import com.digitalBook.entity.User;


@CrossOrigin
@RestController
public class UserControllerImpl implements UserController {

	@Autowired
	UserService userService;
	
	@Override
	public ResponseEntity<String> signUp( User requestMap) {
		
		try {

		return userService.signUp(requestMap);
	}
		catch(Exception ex) {
			ex.printStackTrace();
		}
    return DigitalBooksUtils.getResponseEntity(DigitalBookConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
}

	
}*/
