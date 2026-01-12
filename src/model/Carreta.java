package model;

public class Carreta {
    private String placa;
    private String tipo;
    private int peso_max;
    private int metragem;
    private String statusCarreta;
    private int id;

    public Carreta(int id, String placa, String tipo, String statusCarreta, int peso_max, int metragem) {
        this.id = id;
        this.placa = placa;
        this.tipo = tipo;
        this.peso_max = peso_max;
        this.metragem = metragem;
        this.statusCarreta = statusCarreta;
    }

    public Carreta(String placa, String tipo, String statusCarreta, int peso_max, int metragem) {
        this.placa = placa;
        this.tipo = tipo;
        this.peso_max = peso_max;
        this.metragem = metragem;
        this.statusCarreta = statusCarreta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPeso_max() {
        return peso_max;
    }
    public int getMetragem(){
        return metragem;
    }

    public String getStatus() {
        return statusCarreta;
    }

    public void setStatus(String statusCarreta) {
        this.statusCarreta = statusCarreta;
    }
}