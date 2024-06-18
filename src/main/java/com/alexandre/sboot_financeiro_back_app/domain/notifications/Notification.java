package com.alexandre.sboot_financeiro_back_app.domain.notifications;

import java.util.List;

public class Notification {

    private String nomePropriedade;
    private String mensagem;
    private List<Notification> notifications;

    public Notification(String nomePropriedade, String mensagem) {
        this.nomePropriedade = nomePropriedade;
        this.mensagem = mensagem;
    }

    public Boolean validarPropriedadeString(String valor, String nomePropriedade) {
        if (valor.isEmpty() || nomePropriedade.isEmpty()) {
            this.notifications.add(new Notification("", "Campo Obrigatório"));
            return false;
        }

        return true;
    }
}
