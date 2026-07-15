package com.esmael.SecureAuth.service.impl;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.esmael.SecureAuth.dto.auth.RegisterRequest;
import com.esmael.SecureAuth.dto.auth.RegisterResponse;
import com.esmael.SecureAuth.entity.enums.RoleName;
import com.esmael.SecureAuth.repository.RoleRepository;
import com.esmael.SecureAuth.repository.UserRepository;
import com.esmael.SecureAuth.service.AuthService;
import com.esmael.SecureAuth.entity.Role;
import com.esmael.SecureAuth.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public RegisterResponse register(RegisterRequest request) {
		if(userRepository.existsByEmail(request.getEmail())) {
			throw new RuntimeException("Email already exits");
		}
		Role role = roleRepository.findByName(RoleName.ROLE_USER)
				.orElseThrow(()-> new RuntimeException("Default role not found"));
		String encodedPassword = passwordEncoder.encode(request.getPassword());
		
		User user = User.builder()
		        .firstName(request.getFirstName())
		        .lastName(request.getLastName())
		        .email(request.getEmail())
		        .password(encodedPassword)
		        .enabled(false)
		        .accountNonLocked(true)
		        .failedAttempts(0)
		        .build();
		user.getRoles().add(role);
		User savedUser = userRepository.save(user);
		return RegisterResponse.builder().id(savedUser.getId())
				.firstName(savedUser.getFirstName())
				.lastName(savedUser.getLastName())
				.email(savedUser.getEmail())
				.message("Registration successful")
				.build();
	}
	
	
}
