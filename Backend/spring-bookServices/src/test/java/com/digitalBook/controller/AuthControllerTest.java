package com.digitalBook.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.digitalBook.entity.ERole;
import com.digitalBook.payload.request.LoginRequest;
import com.digitalBook.payload.request.SignupRequest;
import com.digitalBook.payload.response.JwtResponse;
import com.digitalBook.payload.response.MessageResponse;
import com.digitalBook.repository.RoleRepository;
import com.digitalBook.repository.UserRepo;
import com.digitalBook.repository.UserRoleRepo;
import com.digitalBook.security.jwt.JwtUtils;
import com.digitalBook.security.services.UserDetailsImpl;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

	@InjectMocks
	AuthController authController;
	
	
	@Mock
	AuthenticationManager authenticationManager;

	@Mock
	UserRepo userRepository;

	@Mock
	UserRoleRepo userRoleRepo;

	@Mock
	RoleRepository roleRepository;

	@Mock
	PasswordEncoder encoder;

	@Mock
	JwtUtils jwtUtils;
	
	@Test
	public void SignupRequestTest() {
		
		SignupRequest signupRequest=new SignupRequest();
		signupRequest.setEmail("abc@gmail.com");
		signupRequest.setPassword("Test@123");
		signupRequest.setRole(ERole.ROLE_AUTHOR);
		signupRequest.setUsername("abc");
		
		
		assertNotEquals(authController.registerUser(signupRequest),ResponseEntity.ok(new MessageResponse("User registered successfully!")));

		
		
	}

	/*@Test

     void testLoginUser() {

           LoginRequest loginDto = new LoginRequest();

           GrantedAuthority authoritie = new SimpleGrantedAuthority("ROLE_AUTHOR");

           Set<GrantedAuthority> list = new HashSet<>();

           list.add(authoritie);

           UserDetailsImpl detailsImpl = new UserDetailsImpl(1L, loginDto.getUsername(), null, loginDto.getPassword(), list,
   				ERole.ROLE_AUTHOR);
   	}*/

	
	/*@Test

    void testLoginUser() {

           LoginDto loginDto = getLoginDto();

           GrantedAuthority authoritie = new SimpleGrantedAuthority("ROLE_AUTHOR");

           Set<GrantedAuthority> list = new HashSet<>();

           list.add(authoritie);

           UserDetailsImpl detailsImpl = new UserDetailsImpl(1L, "kammalli", loginDto.getEmailId(), loginDto.getPassword(),

                          list);



           Authentication authentication = new UsernamePasswordAuthenticationToken(detailsImpl, list);

           when(authenticationManager

                          .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmailId(), loginDto.getPassword())))

                          .thenReturn(authentication);

           when(jwtUtils.generateJwtToken(authentication)).thenReturn("yeyrbecbdc678");



           assertEquals(loginDto.getEmailId(), authorController.loginUser(loginDto).getBody().getEmail());

    }*/




}
