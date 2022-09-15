package com.digitalBook.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DigitalBooksUtils {
	
	private DigitalBooksUtils() {
		
	}

	
	public static ResponseEntity<String> getResponseEntity(String responseMessage,HttpStatus httpStatus){

         return new ResponseEntity<String>("{\"message\":\"\""+responseMessage+"\"",httpStatus);
}

}
