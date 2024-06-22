package com.alexandre.sboot_financeiro_back_app.domain.services;

import com.alexandre.sboot_financeiro_back_app.presentation.dto.JwtResponse;
import com.alexandre.sboot_financeiro_back_app.presentation.dto.LoginRequest;
import com.alexandre.sboot_financeiro_back_app.presentation.dto.UsuarioRegisterRequest;

public interface AuthenticationService {

    void register(UsuarioRegisterRequest registerRequest);
    JwtResponse login(LoginRequest loginRequest);
}
