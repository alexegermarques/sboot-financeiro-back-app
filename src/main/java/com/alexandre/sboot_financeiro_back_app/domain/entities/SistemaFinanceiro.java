package com.alexandre.sboot_financeiro_back_app.domain.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tb_sistema_financeiro")
public class SistemaFinanceiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer mes;
    private Integer ano;
    private Integer diaFechamento;
    private Boolean gerarCopiaDespesa;
    private Integer mesCopia;
    private Integer anoCopia;

    @OneToMany(mappedBy = "sistemaFinanceiro", cascade = CascadeType.ALL)
    private List<UsuarioSistemaFinanceiro> usuarioSistemaFinanceiros;

    @OneToMany(mappedBy = "sistemaFinanceiro", cascade = CascadeType.ALL)
    private List<Categoria> categorias;
}
