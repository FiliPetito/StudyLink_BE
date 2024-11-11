package com.lykeon.StudyLink.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/test")
public class Test {

    @GetMapping("/private")
    public ResponseEntity<String> secureResource(HttpSession session, HttpServletRequest request){
        return ResponseEntity.ok("Yes, Your JWT Works...");
    }
	
}
