package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class TestController {
	
    private static final Logger LOG = LoggerFactory.getLogger(TestController.class.getName());
	
	@PostMapping("/login")
	public ResponseEntity<String> createAuthenticationToken() throws BadCredentialsException {
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//	    } catch (BadCredentialsException badCredentialsException) {
//	        LOG.error("Incorrect username or password");
//	        throw badCredentialsException;
//	    }
//
//	    final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//	    final String jwt = jwtUtil.generateToken(userDetails);

	    return ResponseEntity.ok("BELLA");
	}
	
}
