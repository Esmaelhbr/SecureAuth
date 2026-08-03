package com.esmael.SecureAuth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esmael.SecureAuth.dto.auth.RegisterRequest;
import com.esmael.SecureAuth.dto.auth.RegisterResponse;
import com.esmael.SecureAuth.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest request){
		System.out.println("Register endpoint called");
		
		RegisterResponse response = authService.register(request);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

}
