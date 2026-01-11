package model;

public class Motorista {
    private String nome;
    private String cpf;
    private String status;
    private int id;

    public Motorista(int id, String nome, String cpf, String status) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.status = status;
    }

    public Motorista(String nome, String cpf, String status) {
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

    public String getCpf() {
        return cpf;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
