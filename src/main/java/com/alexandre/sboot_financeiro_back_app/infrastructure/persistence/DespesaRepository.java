package com.alexandre.sboot_financeiro_back_app.infrastructure.persistence;

import com.alexandre.sboot_financeiro_back_app.domain.entities.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {
}
