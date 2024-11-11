package com.lykeon.StudyLink.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lykeon.StudyLink.entities.User;
import com.lykeon.StudyLink.repositories.UserRepository;

@Service
public class AuthService {

	@Autowired
    private UserRepository userRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;
    
    public User getUserByEmail(String email){
    	Optional<User> user = userRepository.findByEmail(email);
    	if(user.isPresent()) {
        	return user.get();
    	}
    	return null;
    }
	
}
