package com.digitalBook.controller;
import java.util.HashMap;
import java.util.Map;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class BaseController {

		public BaseController() {
			super();
		}
		 @ExceptionHandler(MethodArgumentNotValidException.class)
	       public Map<String, String> handleException(MethodArgumentNotValidException ex) {
           Map<String, String> error = new HashMap<String, String>();
                   ex.getBindingResult().getAllErrors().forEach(e -> {
                	   String fieldName = ((FieldError) e).getField();

	                      String message = ((FieldError) e).getDefaultMessage();

	                      error.put(fieldName, message);

	             });

	              return error;

	       }

	}

