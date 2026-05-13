package model.enums;

public enum StatusVeiculo {

    OCIOSO("Ocioso"),
    EM_VIAGEM("Em viagem"),
    EM_MANUTENCAO("Em manutenção"),
    INDISPONIVEL("Indisponível");

    private String descricao;

    StatusVeiculo(String descricao) {
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
