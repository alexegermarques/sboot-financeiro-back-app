package com.alexandre.sboot_financeiro_back_app.infrastructure.security;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
}
