package com.digitalBook.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path="/digitalBook")
public interface UserController1 {
	
	
	@PostMapping(path="/signup")
	public ResponseEntity<String> signUp(@RequestBody(required=true) Map<String,String> requestMap);

}
