package com.alexandre.sboot_financeiro_back_app.domain.services;

import com.alexandre.sboot_financeiro_back_app.domain.entities.Categoria;

public interface CategoriaService {

    Categoria getCategoriaBySistemaFinanceiro(String emailUsuario);
    void adicionarCategoria(Categoria categoria);
    void atualizarCategoria(Long id, Categoria categoria);
}
