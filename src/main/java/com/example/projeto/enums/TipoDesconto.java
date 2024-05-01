package com.example.projeto.enums;

public enum TipoDesconto {
    PORCENTAGEM(1),
    VALOR_REAL(2);

    private final int value;

    TipoDesconto(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TipoDesconto fromValue(int value) {
        for (TipoDesconto tipo : TipoDesconto.values()) {
            if (tipo.getValue() == value) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de desconto inválido: " + value);
    }
}
