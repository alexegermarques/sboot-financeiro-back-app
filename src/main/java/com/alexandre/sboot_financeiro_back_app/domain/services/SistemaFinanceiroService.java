package com.alexandre.sboot_financeiro_back_app.domain.services;

import com.alexandre.sboot_financeiro_back_app.domain.entities.SistemaFinanceiro;

public interface SistemaFinanceiroService {

    SistemaFinanceiro findUsuarioSistemaFinanceiro(String emailUsuario);
}
