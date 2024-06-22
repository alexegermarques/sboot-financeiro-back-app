package com.alexandre.sboot_financeiro_back_app.presentation.api;

import com.alexandre.sboot_financeiro_back_app.domain.services.AuthenticationService;
import com.alexandre.sboot_financeiro_back_app.presentation.dto.JwtResponse;
import com.alexandre.sboot_financeiro_back_app.presentation.dto.LoginRequest;
import com.alexandre.sboot_financeiro_back_app.presentation.dto.UsuarioRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UsuarioController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(this.authenticationService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UsuarioRegisterRequest request) {
        this.authenticationService.register(request);
        return ResponseEntity.ok().build();
    }
}
