package com.digitalBook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalBook.bookRepo.AuthorRepo;

import com.digitalBook.bookService.AuthorService;


@RestController

public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
	@Autowired
	AuthorRepo authorRepository;
	
	
	@PostMapping()
	 public void createAccount(){
	
	}
	
	
	

	

}
