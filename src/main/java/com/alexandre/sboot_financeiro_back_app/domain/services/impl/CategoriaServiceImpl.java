package com.alexandre.sboot_financeiro_back_app.domain.services.impl;

import com.alexandre.sboot_financeiro_back_app.domain.entities.Categoria;
import com.alexandre.sboot_financeiro_back_app.domain.exceptions.ObjectNotFoundException;
import com.alexandre.sboot_financeiro_back_app.domain.services.CategoriaService;
import com.alexandre.sboot_financeiro_back_app.infrastructure.persistence.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public Categoria getCategoriaBySistemaFinanceiro(String emailUsuario) {
        return this.categoriaRepository.findCategoriaBySistemaFinanceiro(emailUsuario);
    }

    @Override
    public void adicionarCategoria(Categoria categoria) {
        this.categoriaRepository.save(categoria);
    }

    @Override
    public void atualizarCategoria(Long id, Categoria categoriaUpdate) {
        Optional<Categoria> categoriaSaved = this.categoriaRepository.findById(id);

        if (categoriaSaved.isEmpty()) {
            throw new ObjectNotFoundException("Categoria não encotrada com esse ID");
        }

        categoriaSaved.stream().findFirst().ifPresent(categoria -> {
            categoria.setNome(categoriaUpdate.getNome());
            this.categoriaRepository.save(categoria);
        });
    }
}
