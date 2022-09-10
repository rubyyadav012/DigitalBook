package com.digitalBook.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.digitalBook.entity.User;

@RequestMapping(path="/digitalBook")
public interface UserController {
	
	
	@PostMapping(path="/signup")
	public ResponseEntity<String> signUp(@RequestBody(required=true) Map<String,String> requestMap);
	
	
	@PostMapping(path="/Login")
	public ResponseEntity<String> login (@RequestBody(required=true)Map<String,String> requestMap);

}

 
