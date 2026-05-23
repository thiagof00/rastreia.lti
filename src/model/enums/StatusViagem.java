package model.enums;

public enum StatusViagem {

    
    EM_VIAGEM("Em viagem"),
    CONCLUIDO("Concluido");

    private String descricao;

    StatusViagem(String descricao) {
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