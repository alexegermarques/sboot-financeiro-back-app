package com.alexandre.sboot_financeiro_back_app.domain.services.impl;

import com.alexandre.sboot_financeiro_back_app.domain.entities.UsuarioSistemaFinanceiro;
import com.alexandre.sboot_financeiro_back_app.domain.services.UsuarioSistemaFinanceiroService;
import com.alexandre.sboot_financeiro_back_app.infrastructure.persistence.UsuarioSistemaFinanceiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioSistemaFinanceiroServiceImpl implements UsuarioSistemaFinanceiroService {

    private final UsuarioSistemaFinanceiroRepository usuarioSistemaFinanceiroRepository;

    @Override
    public UsuarioSistemaFinanceiro adicionar(UsuarioSistemaFinanceiro object) {
        return null;
    }

    @Override
    public UsuarioSistemaFinanceiro editar(Long id, UsuarioSistemaFinanceiro object) {
        return null;
    }

    @Override
    public void deletar(Long id) {

    }

    @Override
    public UsuarioSistemaFinanceiro buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<UsuarioSistemaFinanceiro> listarTodos() {
        return List.of();
    }
}
