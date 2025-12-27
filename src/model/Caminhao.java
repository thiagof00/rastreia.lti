package model;

public class Caminhao {

    private String placa;
    private String tipo;
    private String status;

    public Caminhao(String placa, String tipo, String status) {
        this.placa = placa;
        this.tipo = tipo;
        this.status = status;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }

    public String getStatus() {
        return status;
    }
}
