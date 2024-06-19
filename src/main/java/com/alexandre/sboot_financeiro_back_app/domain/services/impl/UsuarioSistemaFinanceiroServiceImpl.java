package com.alexandre.sboot_financeiro_back_app.domain.services.impl;

import com.alexandre.sboot_financeiro_back_app.domain.entities.UsuarioSistemaFinanceiro;
import com.alexandre.sboot_financeiro_back_app.domain.services.UsuarioSistemaFinanceiroService;
import com.alexandre.sboot_financeiro_back_app.infrastructure.persistence.UsuarioSistemaFinanceiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioSistemaFinanceiroServiceImpl implements UsuarioSistemaFinanceiroService {

    private final UsuarioSistemaFinanceiroRepository usuarioSistemaFinanceiroRepository;

    @Override
    public void cadastrarUsuarioNoSistema(UsuarioSistemaFinanceiro usuarioSistemaFinanceiro) {
        this.usuarioSistemaFinanceiroRepository.save(usuarioSistemaFinanceiro);
    }
}
