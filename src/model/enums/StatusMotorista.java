package model.enums;

public enum StatusMotorista {

    OCIOSO("Ocioso"),
    EM_VIAGEM("Em viagem"),
    INDISPONIVEL("Indisponível");

    private String descricao;

    StatusMotorista(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
