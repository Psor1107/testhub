package br.ufscar.dc.dsw.util;

public enum StatusBugTeste {
    ABERTO("aberto"),
    FECHADO("fechado");

    private final String status;

    StatusBugTeste(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static StatusBugTeste parseStatus(String input) {
        for (StatusBugTeste statusEnum : StatusBugTeste.values()) {
            if (statusEnum.status.equalsIgnoreCase(input)) {
                return statusEnum;
            }
        }
        throw new IllegalArgumentException("Status inválido");
    }
}
