package model;

import model.enums.StatusVeiculo;

public abstract class Veiculo {

    private int id;
    private String placa;
    private String tipo;
    private StatusVeiculo status;

    public Veiculo(String placa, String tipo, StatusVeiculo status) {
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

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public StatusVeiculo getStatus() {
        return status;
    }

    public void setStatus(StatusVeiculo status) {
        this.status = status;
    }

}