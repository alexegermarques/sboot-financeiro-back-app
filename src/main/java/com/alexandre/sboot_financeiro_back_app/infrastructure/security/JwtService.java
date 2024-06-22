package com.alexandre.sboot_financeiro_back_app.infrastructure.security;

import org.springframework.security.core.Authentication;

public interface JwtService {
    String getUserNameToken(String token);
    String generateToken(Authentication authentication);
    boolean isTokenValido(String token);
}
