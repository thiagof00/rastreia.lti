package model;

public class Motorista {
    private String nome;
    private String cpf;
    private String status;

    public Motorista(String nome, String cpf, String status) {
        this.nome = nome;
        this.cpf = cpf;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getStatus() {
        return status;
    }
}
