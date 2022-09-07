package com.digitalBook.controller;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.security.authentication.AuthenticationManager;

import com.digitalBook.bookService.AuthorService;
import com.digitalBook.entity.Author;

import com.digitalBook.repository.AuthorRepo;


@RestController
@RequestMapping("/digitalbooks/author")

public class AuthorController {
	
	

		/*@Autowired
		AuthorService authorService;

		@Autowired
		AuthorRepo authorRepo;
		@Autowired
		AuthenticationManager authentiactionManager;

		@PostMapping("/login")
		ResponseEntity login(@Valid @RequestBody Author author) {
			Authentication authentication;
			authentication = authentiactionManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return new ResponseEntity<>(HttpStatus.OK);
		}

		@PostMapping("/signup")
		ResponseEntity createAuthorAccount(@Valid @RequestBody User user) {

			if (userRepo.existsByemail(user.getEmail())) {
				return ResponseEntity.badRequest().body("Email exist already!Please try with different mailid");
			}
			if (userRepo.existsByusername(user.getUsername())) {
				return ResponseEntity.badRequest().body("UserName exist already!Please try with different username");
			}

			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encryptedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encryptedPassword);
			userService.createAuthor(user);

			return ResponseEntity.ok("User registered successfully");
		}
*/
	
}
