package com.digitalBook.bookService;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface UserService1 {

	public ResponseEntity<String> signUp(Map<String, String> requestMap);

}
