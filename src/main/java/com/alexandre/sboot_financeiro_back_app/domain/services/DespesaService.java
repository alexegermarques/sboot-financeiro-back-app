package com.alexandre.sboot_financeiro_back_app.domain.services;

import com.alexandre.sboot_financeiro_back_app.domain.entities.Despesa;

import java.util.List;

public interface DespesaService {

    List<Despesa> findDespesasNaoPagasMesAnterior(String emailUsuario);
    void adicionarDespesa(Despesa despesa);
    void atualizarDespesa(Long id, Despesa despesaUpdate);
}
