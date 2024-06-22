package com.alexandre.sboot_financeiro_back_app.infrastructure.security;

import com.alexandre.sboot_financeiro_back_app.domain.exceptions.ObjectNotFoundException;
import com.alexandre.sboot_financeiro_back_app.infrastructure.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return login -> userRepository.findByLogin(login)
                .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
    }
}
