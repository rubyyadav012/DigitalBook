package com.digitalBook.controller;

//import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.digitalBook.entity.User;
import com.digitalBook.repository.UserRepo;

@RestController
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	UserRepo userRepo;
	
	 /*@PostMapping("/author/signup")
	    public Status registerUser(@Valid @RequestBody User newUser) {
	        List<User> users = userRepo.findAll();
	        System.out.println("New user: " + newUser.toString());
	        for (User user : users) {
	            System.out.println("Registered user: " + newUser.toString());
	            if (user.equals(newUser)) {
	                System.out.println("User Already exists!");
	                return Status.USER_ALREADY_EXISTS;
	            }
	        }
	        userRepo.save(newUser);
	        return Status.SUCCESS;
	    }
	    @PostMapping("/author/login")
	    public Status loginUser(@Valid @RequestBody User user) {
	        List<User> users = userRepo.findAll();
	        for (User other : users) {
	            if (other.equals(user)) {
	                user.setLoggedIn(true);
	                userRepo.save(user);
	                return Status.SUCCESS;
	            }
	        }
	        return Status.FAILURE;
	    }
	    @PostMapping("/author/logout")
	    public Status logUserOut(@Valid @RequestBody User user) {
	        List<User> users = userRepo.findAll();
	        for (User other : users) {
	            if (other.equals(user)) {
	                user.setLoggedIn(false);
	                userRepo.save(user);
	                return Status.SUCCESS;
	            }
	        }
	        return Status.FAILURE;
	    }
	    @DeleteMapping("/user/all")
	    public Status deleteUsers() {
	        userRepo.deleteAll();
	        return Status.SUCCESS;
	    }*/
	
	/*@PostMapping(path="/signup")
	public ResponseEntity<String> signup(@RequestBody(required=true)Map<String,String> requestMapping){
	}
*/
	
}

