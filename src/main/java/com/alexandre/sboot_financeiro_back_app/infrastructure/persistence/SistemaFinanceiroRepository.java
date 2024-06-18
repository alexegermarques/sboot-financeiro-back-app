package com.alexandre.sboot_financeiro_back_app.infrastructure.persistence;

import com.alexandre.sboot_financeiro_back_app.domain.entities.SistemaFinanceiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SistemaFinanceiroRepository extends JpaRepository<SistemaFinanceiro, Long> {

    @Query("SELECT s FROM SistemaFinanceiro s " +
           "INNER JOIN s.usuarioSistemaFinanceiros us " +
           "WHERE us.emailUsuario = :emailUsuario")
    SistemaFinanceiro findUsuarioSistemaFinanceiro(@Param("emailUsuario") String emailUsuario);
}
