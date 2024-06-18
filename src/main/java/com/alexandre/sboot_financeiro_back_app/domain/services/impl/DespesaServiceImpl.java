package com.alexandre.sboot_financeiro_back_app.domain.services.impl;

import com.alexandre.sboot_financeiro_back_app.domain.entities.Despesa;
import com.alexandre.sboot_financeiro_back_app.domain.services.DespesaService;
import com.alexandre.sboot_financeiro_back_app.infrastructure.persistence.DespesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DespesaServiceImpl implements DespesaService {

    private final DespesaRepository despesaRepository;

    @Override
    public List<Despesa> findDespesasNaoPagasMesAnterior(String emailUsuario) {
        return despesaRepository.findDespesasNaoPagasMesAnterior(emailUsuario);
    }
}
