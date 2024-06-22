package com.alexandre.sboot_financeiro_back_app.domain.services.impl;

import com.alexandre.sboot_financeiro_back_app.domain.entities.Role;
import com.alexandre.sboot_financeiro_back_app.domain.entities.Usuario;
import com.alexandre.sboot_financeiro_back_app.domain.enums.RoleEnum;
import com.alexandre.sboot_financeiro_back_app.domain.exceptions.BusinessException;
import com.alexandre.sboot_financeiro_back_app.domain.services.AuthenticationService;
import com.alexandre.sboot_financeiro_back_app.infrastructure.persistence.RoleRepository;
import com.alexandre.sboot_financeiro_back_app.infrastructure.persistence.UserRepository;
import com.alexandre.sboot_financeiro_back_app.infrastructure.security.JwtService;
import com.alexandre.sboot_financeiro_back_app.presentation.dto.JwtResponse;
import com.alexandre.sboot_financeiro_back_app.presentation.dto.LoginRequest;
import com.alexandre.sboot_financeiro_back_app.presentation.dto.UsuarioRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public void register(UsuarioRegisterRequest registerRequest) {
        Boolean usuarioExistente = this.userRepository.existsByLogin(registerRequest.getLogin());

        if (Boolean.TRUE.equals(usuarioExistente)) {
            throw new BusinessException("Usuário já está cadastrado!");
        }

        Usuario usuario = new Usuario();
        usuario.setLogin(registerRequest.getLogin());
        usuario.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        Role role = this.roleRepository.findByName(RoleEnum.ROLE_USER.getRoleName())
                                       .orElse(null);
        usuario.getRoles().add(role);

        this.userRepository.save(usuario);
    }

    @Override
    public JwtResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword()));
        String token = jwtService.generateToken(authentication);
        return JwtResponse.builder().token(token).build();
    }
}
