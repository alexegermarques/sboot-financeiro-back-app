package com.alexandre.sboot_financeiro_back_app.presentation.api;

import com.alexandre.sboot_financeiro_back_app.domain.services.CategoriaService;
import com.alexandre.sboot_financeiro_back_app.presentation.dto.CategoriaResponseDTO;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.alexandre.sboot_financeiro_back_app.presentation.mapper.CategoriaMapper.toResponse;

@RestController
@RequestMapping("/v1/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<CategoriaResponseDTO> findCategoriaBySistemaFinanceiro(@PathParam("emailUsuario") String emailUsuario) {
        return ResponseEntity.ok(toResponse(this.categoriaService.getCategoriaBySistemaFinanceiro(emailUsuario)));
    }
}
