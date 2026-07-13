package com.esmael.SecureAuth.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.esmael.SecureAuth.entity.Role;
import com.esmael.SecureAuth.entity.enums.RoleName;
import com.esmael.SecureAuth.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

	private final RoleRepository roleRepository;

	@Override
	public void run(String... args) throws Exception {
		 if (roleRepository.findByName(RoleName.ROLE_USER).isEmpty()) {
	            roleRepository.save(
	                    Role.builder()
	                            .name(RoleName.ROLE_USER)
	                            .build()
	            );
	        }
		 
		   if (roleRepository.findByName(RoleName.ROLE_ADMIN).isEmpty()) {
	            roleRepository.save(
	                    Role.builder()
	                            .name(RoleName.ROLE_ADMIN)
	                            .build()
	            );
	        }
	}
	
	
	
	
}
