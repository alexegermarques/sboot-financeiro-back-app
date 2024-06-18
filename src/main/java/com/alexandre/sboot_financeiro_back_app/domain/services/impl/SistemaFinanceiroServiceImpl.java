package com.alexandre.sboot_financeiro_back_app.domain.services.impl;

import com.alexandre.sboot_financeiro_back_app.domain.entities.SistemaFinanceiro;
import com.alexandre.sboot_financeiro_back_app.domain.services.SistemaFinanceiroService;
import com.alexandre.sboot_financeiro_back_app.infrastructure.persistence.SistemaFinanceiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SistemaFinanceiroServiceImpl implements SistemaFinanceiroService {

    private final SistemaFinanceiroRepository sistemaFinanceiroRepository;

    @Override
    public SistemaFinanceiro findUsuarioSistemaFinanceiro(String emailUsuario) {
        return sistemaFinanceiroRepository.findUsuarioSistemaFinanceiro(emailUsuario);
    }
}
