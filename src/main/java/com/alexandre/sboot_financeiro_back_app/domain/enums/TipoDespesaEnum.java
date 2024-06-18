package com.alexandre.sboot_financeiro_back_app.domain.enums;

import lombok.Getter;

@Getter
public enum TipoDespesaEnum {

    CONTAS(1),
    INVESTIMENTOS(2)
    ;

    private final Integer tipo;

    TipoDespesaEnum(Integer tipo) {
        this.tipo = tipo;
    }
}
