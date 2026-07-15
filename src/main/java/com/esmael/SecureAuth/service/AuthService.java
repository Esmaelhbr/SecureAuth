package com.esmael.SecureAuth.service;

import com.esmael.SecureAuth.dto.auth.RegisterRequest;
import com.esmael.SecureAuth.dto.auth.RegisterResponse;

public interface AuthService {
	
	RegisterResponse register(RegisterRequest request);

}
