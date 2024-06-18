package com.alexandre.sboot_financeiro_back_app.infrastructure.persistence;

import com.alexandre.sboot_financeiro_back_app.domain.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query("SELECT c FROM Categoria c " +
           "INNER JOIN c.sistemaFinanceiro s " +
           "INNER JOIN s.usuarioSistemaFinanceiros us " +
           "WHERE us.emailUsuario = :emailUsuario " +
           "AND us.sistemaAtual = true")
    Categoria findCategoriaBySistemaFinanceiro(@Param("emailUsuario") String emailUsuario);
}