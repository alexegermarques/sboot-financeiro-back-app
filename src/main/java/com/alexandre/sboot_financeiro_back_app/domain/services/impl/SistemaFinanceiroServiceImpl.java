package com.alexandre.sboot_financeiro_back_app.domain.services.impl;

import com.alexandre.sboot_financeiro_back_app.domain.entities.SistemaFinanceiro;
import com.alexandre.sboot_financeiro_back_app.domain.exceptions.ObjectNotFoundException;
import com.alexandre.sboot_financeiro_back_app.domain.services.SistemaFinanceiroService;
import com.alexandre.sboot_financeiro_back_app.infrastructure.persistence.SistemaFinanceiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SistemaFinanceiroServiceImpl implements SistemaFinanceiroService {

    private final SistemaFinanceiroRepository sistemaFinanceiroRepository;

    @Override
    public SistemaFinanceiro findUsuarioSistemaFinanceiro(String emailUsuario) {
        return sistemaFinanceiroRepository.findUsuarioSistemaFinanceiro(emailUsuario);
    }

    @Override
    public void adicionarSistemaFinanceiro(SistemaFinanceiro sistemaFinanceiro) {
        LocalDateTime dateTime = LocalDateTime.now();
        sistemaFinanceiro.setDiaFechamento(1);
        sistemaFinanceiro.setAno(dateTime.getYear());
        sistemaFinanceiro.setMes(dateTime.getMonthValue());
        sistemaFinanceiro.setAnoCopia(dateTime.getYear());
        sistemaFinanceiro.setMesCopia(dateTime.getMonthValue());
        sistemaFinanceiro.setGerarCopiaDespesa(Boolean.TRUE);

        this.sistemaFinanceiroRepository.save(sistemaFinanceiro);
    }

    @Override
    public void atualizarSistemaFinanceiro(Long id, SistemaFinanceiro sistemaFinanceiroUpdate) {
        Optional<SistemaFinanceiro> sistemaFinanceiroSaved = this.sistemaFinanceiroRepository.findById(id);

        if (sistemaFinanceiroSaved.isEmpty()) {
            throw new ObjectNotFoundException("ID inexistente");
        }

        sistemaFinanceiroSaved.stream().findFirst().ifPresent(sistemaFinanceiroExistente -> {
            sistemaFinanceiroExistente.setNome(sistemaFinanceiroUpdate.getNome());
            sistemaFinanceiroExistente.setDiaFechamento(1);
            this.sistemaFinanceiroRepository.save(sistemaFinanceiroExistente);
        });
    }
}
