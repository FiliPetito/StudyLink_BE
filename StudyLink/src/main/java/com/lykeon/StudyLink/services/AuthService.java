package com.lykeon.StudyLink.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lykeon.StudyLink.dtos.UserDto;
import com.lykeon.StudyLink.entities.Role;
import com.lykeon.StudyLink.entities.User;
import com.lykeon.StudyLink.repositories.RoleRepository;
import com.lykeon.StudyLink.repositories.UserRepository;
import com.lykeon.StudyLink.utils.ConverterUtils;

@Service
public class AuthService {
	
    private static final Logger LOG = LoggerFactory.getLogger(AuthService.class.getName());

	@Autowired
    private UserRepository userRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepository roleRepository;
    
    public User getUserByEmail(String email){
    	Optional<User> user = userRepository.findByEmail(email);
    	if(user.isPresent()) {
        	return user.get();
    	}
    	return null;
    }
    
    public boolean checkEmailExist(String email) {
    	Optional<User> user = userRepository.findByEmail(email);
    	if(user.isPresent()) {
        	return true;
    	}
    	return false;
    }
	
    public boolean checkUsernameExist(String username) {
    	Optional<User> user = userRepository.findByUsername(username);
    	if(user.isPresent()) {
        	return true;
    	}
    	return false;
    }
    
    public boolean isValidPassword(String password) {
        // Verifica che la password sia di almeno 8 caratteri
        if (password.length() < 8) {
            return false;
        }
        
        // Flag per ogni requisito
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        // Controllo ogni carattere della password
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        // Verifica se tutti i requisiti sono soddisfatti
        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }
    
    public User createNewUser(UserDto userDto) {
        LOG.info("AuthService - [createNewUser] - Start.");
        
        User newUser = new User();
        Role userRole = new Role();
        
        try {
            // Conversione dal dto alla entity
            newUser = ConverterUtils.convertUserDtoToUser(userDto);
            newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));

            // Ricavo il ruolo di default da aggiungere
            userRole = roleRepository.findById(2L).orElseThrow(() -> new RuntimeException("AuthService - [createNewUser] - Ruolo non trovato"));
            
            // Inizializzazione del Set di ruoli
            Set<Role> list = new HashSet<>();
            list.add(userRole);
            
            newUser.setRoles(list);
            
            // Salvataggio dell'utente
            newUser = userRepository.save(newUser);
            
        } catch (Exception e) {
            LOG.error("AuthService - [createNewUser] - Error: " + e.getMessage());
        }
        LOG.info("AuthService - [createNewUser] - End.");
        return newUser;
    }
}

