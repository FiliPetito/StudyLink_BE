package com.lykeon.StudyLink.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lykeon.StudyLink.dtos.UserDto;
import com.lykeon.StudyLink.exceptions.InvalidPayloadException;
import com.lykeon.StudyLink.exceptions.UserIdAlreadyExistException;
import com.lykeon.StudyLink.services.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Objects;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto, HttpSession session, HttpServletRequest request) {
        if (Objects.isNull(userDto)) {
            throw new InvalidPayloadException("Payload cannot be Null");
        }
        if(userService.findByUsername(userDto.getUsername())){
            throw new UserIdAlreadyExistException("Username is already taken");
        }
        return userService.saveUser(userDto);
    }
}
