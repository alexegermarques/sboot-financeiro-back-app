package com.alexandre.sboot_financeiro_back_app.infrastructure.persistence;

import com.alexandre.sboot_financeiro_back_app.domain.entities.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    @Query("SELECT d FROM Despesa d " +
           "INNER JOIN d.categoria c " +
           "INNER JOIN c.sistemaFinanceiro s " +
           "INNER JOIN s.usuarioSistemaFinanceiros us " +
           "WHERE us.emailUsuario = :emailUsuario AND FUNCTION('MONTH', d.mes) < FUNCTION('MONTH', CURRENT_TIMESTAMP) " +
           "AND d.pago = FALSE")
    List<Despesa> findDespesasNaoPagasMesAnterior(@Param("emailUsuario") String emailUsuario);
}
