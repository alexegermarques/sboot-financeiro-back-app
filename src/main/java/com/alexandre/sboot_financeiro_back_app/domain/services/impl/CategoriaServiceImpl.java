package com.alexandre.sboot_financeiro_back_app.domain.services.impl;

import com.alexandre.sboot_financeiro_back_app.domain.entities.Categoria;
import com.alexandre.sboot_financeiro_back_app.domain.exceptions.ObjectNotFoundException;
import com.alexandre.sboot_financeiro_back_app.domain.services.CategoriaService;
import com.alexandre.sboot_financeiro_back_app.infrastructure.persistence.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public Categoria adicionar(Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }

    @Override
    public Categoria editar(Long id, Categoria categoriaUpdate) {
        Categoria categoriaSaved = this.categoriaRepository.findById(id)
                            .orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada!"));

        BeanUtils.copyProperties(categoriaUpdate, categoriaSaved);

        return this.categoriaRepository.save(categoriaUpdate);
    }

    @Override
    public void deletar(Long id) {
        this.categoriaRepository.findById(id)
                                .orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada!"));
        this.categoriaRepository.deleteById(id);
    }

    @Override
    public Categoria buscarPorId(Long id) {
        return this.categoriaRepository.findById(id)
                   .orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada!"));
    }

    @Override
    public List<Categoria> listarTodos() {
        return this.categoriaRepository.findAll();
    }
}
