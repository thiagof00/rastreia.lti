package model;

import model.enums.StatusMotorista;

public class Motorista {
    private String nome;
    private String cpf;
    private StatusMotorista status;
    private int id;

    public Motorista(String nome, String cpf, StatusMotorista status) {
        this.nome = nome;
        this.cpf = cpf;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public StatusMotorista getStatus() {
        return status;
    }

    public void setStatus(StatusMotorista status) {
        this.status = status;
    }
}