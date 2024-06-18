package com.alexandre.sboot_financeiro_back_app.domain.services;

import com.alexandre.sboot_financeiro_back_app.domain.entities.Categoria;

public interface CategoriaService extends GenericCrud<Categoria> {

    Categoria getCategoriaBySistemaFinanceiro(String emailUsuario);
}
