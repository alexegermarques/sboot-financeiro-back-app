package com.alexandre.sboot_financeiro_back_app.presentation.mapper;

import com.alexandre.sboot_financeiro_back_app.domain.entities.Categoria;
import com.alexandre.sboot_financeiro_back_app.presentation.dto.CategoriaResponseDTO;
import org.springframework.beans.BeanUtils;

public class CategoriaMapper {

    private CategoriaMapper() {
    }

    public static CategoriaResponseDTO toResponse(Categoria categoria) {
        CategoriaResponseDTO responseDTO = new CategoriaResponseDTO();
        BeanUtils.copyProperties(categoria, responseDTO);
        return responseDTO;
    }
}
