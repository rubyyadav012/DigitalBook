package com.digitalBook.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.digitalBook.repository.RoleRepository;
import com.digitalBook.repository.UserRepo;
import com.digitalBook.repository.UserRoleRepo;
import com.digitalBook.security.jwt.JwtUtils;
import com.digitalBook.security.services.*;
import com.digitalBook.entity.Role;
import com.digitalBook.entity.User1;
import com.digitalBook.entity.UserRole;
import com.digitalBook.payload.request.LoginRequest;
import com.digitalBook.payload.request.SignupRequest;
import com.digitalBook.payload.response.JwtResponse;
import com.digitalBook.payload.response.MessageResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepo userRepository;

	@Autowired
	UserRoleRepo userRoleRepo;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		roles.add(userDetails.getRole().toString());
		return ResponseEntity
				.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(),

						roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

		User1 user = new User1(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()), signUpRequest.getRole());

		UserRole userRole = new UserRole();

		signUpRequest.getRoles();
		Set<Role> roles = new HashSet<>();
		for (Role role : roles) {
			userRole.setRole_id(role.getId());
		}

		user.setRoles(roles);
		System.out.println("userRole" + user.getRole());
		userRepository.save(user);
		
		//userRole.setUser_id(user.getId());

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
