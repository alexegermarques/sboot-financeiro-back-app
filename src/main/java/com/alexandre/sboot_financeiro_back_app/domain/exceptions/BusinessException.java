package com.alexandre.sboot_financeiro_back_app.domain.exceptions;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
