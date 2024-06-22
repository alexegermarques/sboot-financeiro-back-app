package com.alexandre.sboot_financeiro_back_app.domain.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {

    ROLE_ADMIN("ADMIN"),
    ROLE_USER("USER")
    ;

    private final String roleName;

    RoleEnum(String roleName) {
        this.roleName = roleName;
    }
}
