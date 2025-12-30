package model;

public class Carga {

    private int invoice;
    private String placaCaminhao;
    private String placaCarga1;
    private String placaCarga2;
    private String notaFiscal;
    private int id;

    public Carga(int id, int invoice, String placaCaminhao, String placaCarga1, String placaCarga2, String notaFiscal) {
        this.id = id;
        this.invoice = invoice;
        this.placaCaminhao = placaCaminhao;
        this.placaCarga1 = placaCarga1;
        this.placaCarga2 = placaCarga2;
        this.notaFiscal = notaFiscal;
    }

    public Carga(int invoice, String placaCaminhao, String placaCarga1, String placaCarga2, String notaFiscal) {
        this.invoice = invoice;
        this.placaCaminhao = placaCaminhao;
        this.placaCarga1 = placaCarga1;
        this.placaCarga2 = placaCarga2;
        this.notaFiscal = notaFiscal;
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

    public String getPlacaCaminhao() {
        return placaCaminhao;
    }

    public String getPlacaCarga1() {
        return placaCarga1;
    }

    public String getPlacaCarga2() {
        return placaCarga2;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

}
