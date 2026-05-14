package model;

import model.enums.StatusViagem;

public class Carga {

    private int id;
    protected int invoice;
    protected String notaFiscal;
    protected StatusViagem status;
    protected String destino;
    protected String localidade;
    protected String origem;
    protected String PO;

    public Carga(int invoice,  String PO, String notaFiscal, String origem, String localidade, String destino, StatusViagem status) {
        this.invoice = invoice;
        this.PO = PO;
        this.notaFiscal = notaFiscal;
        this.origem = origem;
        this.localidade = localidade;
        this.destino = destino;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoice() {
        return invoice;
    }

    public void setInvoice(int novoInvoice) {
        this.invoice = novoInvoice;
    }

    public String getPO() {
        return PO;
    }

    public void setPO(String novoPO) {
        this.PO = novoPO;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String novaOrigem) {
        this.origem = novaOrigem;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String novoDestino) {
        this.destino = novoDestino;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String novaNotaFiscal) {
        this.notaFiscal = novaNotaFiscal;
    }

    public StatusViagem getStatus() {
        return status;
    }

    public void setStatus(StatusViagem status) {
        this.status = status;
    }

}