package com.alexandre.sboot_financeiro_back_app.domain.entities;

import jakarta.persistence.Entity;
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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tb_usuarios_sistema_financeiro")
public class UsuarioSistemaFinanceiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String emailUsuario;
    private Boolean administrador;
    private Boolean sistemaAtual;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sistema_id")
    private SistemaFinanceiro sistemaFinanceiro;
}
