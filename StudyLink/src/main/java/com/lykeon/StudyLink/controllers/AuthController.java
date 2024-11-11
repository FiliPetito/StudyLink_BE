package com.lykeon.StudyLink.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.lykeon.StudyLink.entities.User;
import com.lykeon.StudyLink.request.AuthenticationRequest;
import com.lykeon.StudyLink.response.AuthenticationResponse;
import com.lykeon.StudyLink.response.DefaultResponse;
import com.lykeon.StudyLink.security.jwt.JwtUtil;
import com.lykeon.StudyLink.services.AuthService;
import com.lykeon.StudyLink.utils.ResponseUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthService authService;
    
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class.getName());

    @PostMapping("/login")
    public ResponseEntity<DefaultResponse<AuthenticationResponse>> createAuthenticationToken(
            @RequestBody AuthenticationRequest authenticationRequest) throws BadCredentialsException {

    		User user = new User();
    		DefaultResponse<AuthenticationResponse> a;
        try {
        	user = authService.getUserByEmail(authenticationRequest.getEmail());
        	if(user == null) {
        		 //return ResponseUtils.createErrorResponse("404", "Email non trovata", HttpStatus.NOT_FOUND);
                 a = new DefaultResponse<AuthenticationResponse>("emailNotPresent", "L'email non è presente o errata.", HttpStatus.UNAUTHORIZED);
                 return new ResponseEntity<>(a, HttpStatus.UNAUTHORIZED);
        	}
        	
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDetails.getUsername(), authenticationRequest.getPassword()));
            
            final String jwt = jwtUtil.generateToken(userDetails);
            
            AuthenticationResponse authResponse = new AuthenticationResponse(jwt);
            a = new DefaultResponse<AuthenticationResponse>("accessGranted", "Autenticazione avvenuta con successo", HttpStatus.OK);
            a.setData(authResponse);
            return new ResponseEntity<>(a, HttpStatus.OK);
        			
            
            //return ResponseUtils.createSuccessResponse(authResponse, "Autenticazione avvenuta con successo");
        } catch (BadCredentialsException badCredentialsException) {
            a = new DefaultResponse<AuthenticationResponse>("credentialIncorrect", "Username o password errati", HttpStatus.UNAUTHORIZED);
            return new ResponseEntity<>(a, HttpStatus.UNAUTHORIZED);
            //return ResponseUtils.createErrorResponse("401", "Username o password errati", HttpStatus.UNAUTHORIZED);
        }
    }

}

