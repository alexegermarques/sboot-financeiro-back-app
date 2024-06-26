package com.alexandre.sboot_financeiro_back_app.infrastructure.persistence;

import com.alexandre.sboot_financeiro_back_app.domain.entities.UsuarioSistemaFinanceiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioSistemaFinanceiroRepository extends JpaRepository<UsuarioSistemaFinanceiro, Long> {
}
