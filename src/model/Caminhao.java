package model;

public class Caminhao {

    private String placa;
    private String tipo;
    private String status;
    private int id;

    public Caminhao(int id, String placa, String tipo, String status) {
        this.id = id;
        this.placa = placa;
        this.tipo = tipo;
        this.status = status;
    }

    public Caminhao(String placa, String tipo, String status) {
        this.placa = placa;
        this.tipo = tipo;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
