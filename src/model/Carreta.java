package model;

import model.enums.StatusVeiculo;

public class Carreta extends Veiculo {
    private int peso_max;
    private int metragem;

    public Carreta(String placa, String tipo, StatusVeiculo status, int peso_max, int metragem) {
        super(placa, tipo, status);
        this.peso_max = peso_max;
        this.metragem = metragem;

    }

    public int getPeso_max() {
        return peso_max;
    }

    public int getMetragem() {
        return metragem;
    }

    public void setPeso_max(int peso_max) {
        this.peso_max = peso_max;
    }

    public void setMetragem(int metragem) {
        this.metragem = metragem;
    }
}