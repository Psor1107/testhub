package br.ufscar.dc.dsw.util;

public enum GravidadeTeste {
    BAIXA("baixa"),
    MEDIA("media"),
    ALTA("alta");

    private final String gravidade;

    GravidadeTeste(String gravidade) {
        this.gravidade = gravidade;
    }

    public String getStatus() {
        return gravidade;
    }

    public static GravidadeTeste parseStatus(String input) {
        for (GravidadeTeste statusEnum : GravidadeTeste.values()) {
            if (statusEnum.gravidade.equalsIgnoreCase(input)) {
                return statusEnum;
            }
        }
        throw new IllegalArgumentException("Gravidade inválido");
    }
}
