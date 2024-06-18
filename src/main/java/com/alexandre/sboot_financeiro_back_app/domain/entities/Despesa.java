package com.alexandre.sboot_financeiro_back_app.domain.entities;

import com.alexandre.sboot_financeiro_back_app.domain.enums.TipoDespesaEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tb_despesas")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal valor;
    private Integer mes;
    private Integer ano;

    @Enumerated(EnumType.ORDINAL)
    private TipoDespesaEnum tipoDespesaEnum;
    private Instant dataCadastro = Instant.now();
    private Instant dataAlteracao;
    private Instant dataPagamento;
    private Instant dataVencimento;
    private Boolean pago;
    private Boolean despesaAtrasada;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
