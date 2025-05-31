package br.ufscar.dc.dsw.util;

public enum StatusSessaoTeste {
    CRIADO("criado"),
    EM_EXECUCAO("em_execucao"),
    FINALIZADO("finalizado");

    private final String status;

    StatusSessaoTeste(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static StatusSessaoTeste parseStatus(String input) {
        for (StatusSessaoTeste statusEnum : StatusSessaoTeste.values()) {
            if (statusEnum.status.equalsIgnoreCase(input)) {
                return statusEnum;
            }
        }
        throw new IllegalArgumentException("Status inválido");
    }
}
