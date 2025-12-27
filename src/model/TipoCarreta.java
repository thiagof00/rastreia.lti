package model;

public class TipoCarreta {
    private String tipo;
    private int capacidade;
    private int qtdPlacas;

    public TipoCarreta(String tipo, int capacidade, int qtdPlacas) {
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.qtdPlacas = qtdPlacas;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getQtdPlacas() {
        return qtdPlacas;
    }
}
