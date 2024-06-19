package com.alexandre.sboot_financeiro_back_app.domain.services.impl;

import com.alexandre.sboot_financeiro_back_app.domain.entities.Despesa;
import com.alexandre.sboot_financeiro_back_app.domain.exceptions.ObjectNotFoundException;
import com.alexandre.sboot_financeiro_back_app.domain.services.DespesaService;
import com.alexandre.sboot_financeiro_back_app.infrastructure.persistence.DespesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DespesaServiceImpl implements DespesaService {

    private final DespesaRepository despesaRepository;

    @Override
    public List<Despesa> findDespesasNaoPagasMesAnterior(String emailUsuario) {
        return despesaRepository.findDespesasNaoPagasMesAnterior(emailUsuario);
    }

    @Override
    public void adicionarDespesa(Despesa despesa) {
        LocalDateTime dateTime = LocalDateTime.now();

        despesa.setDataCadastro(Instant.now());
        despesa.setMes(dateTime.getMonthValue());
        despesa.setAno(dateTime.getYear());
        this.despesaRepository.save(despesa);
    }

    @Override
    public void atualizarDespesa(Long id, Despesa despesaUpdate) {
        Optional<Despesa> despesaExistente = this.despesaRepository.findById(id);

        if (despesaExistente.isEmpty()) {
            throw new ObjectNotFoundException("Nenuma despesa existente com esse Id");
        }

        despesaExistente.stream().findFirst().ifPresent(despesa -> {
            despesa.setNome(despesaUpdate.getNome());
            despesa.setDataPagamento(Boolean.TRUE.equals(despesaUpdate.getPago()) ? Instant.now() : null);
            this.despesaRepository.save(despesa);
        });
    }
}
