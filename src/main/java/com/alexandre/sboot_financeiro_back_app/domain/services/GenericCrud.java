package com.alexandre.sboot_financeiro_back_app.domain.services;

import java.util.List;

public interface GenericCrud<T> {

    T adicionar(T object);
    T editar(Long id, T object);
    void deletar(Long id);
    T buscarPorId(Long id);
    List<T> listarTodos();
}
