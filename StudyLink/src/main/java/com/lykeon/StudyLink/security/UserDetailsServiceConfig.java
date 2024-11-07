package com.lykeon.StudyLink.security;

import com.lykeon.StudyLink.entities.User;
import com.lykeon.StudyLink.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


@Configuration
public class UserDetailsServiceConfig {

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            Optional<User> user = userRepository.findByUsername(username);
            if (!user.isPresent()) {
                throw new UsernameNotFoundException("User not found");
            }
            return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), user.get().getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList()));
        };
    }
}

