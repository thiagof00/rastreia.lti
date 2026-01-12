package model;

public class TipoCarreta {
    private String tipo;
    private int capacidade;
    private int qtdPlacas;
    private int id;

    public TipoCarreta(int id, String tipo, int capacidade, int qtdPlacas) {
        this.id = id;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.qtdPlacas = qtdPlacas;
    }

    public TipoCarreta(String tipo, int capacidade, int qtdPlacas) {
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.qtdPlacas = qtdPlacas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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