package model;

public class Carga {

    private int invoice;
    private Caminhao placaCaminhao;
    private Carreta placaCarreta1;
    private Carreta placaCarreta2;
    private String notaFiscal;
    private int id;

    public Carga(int id, int invoice, Caminhao placaCaminhao, Carreta placaCarreta1, Carreta placaCarreta2, String notaFiscal) {
        this.id = id;
        this.invoice = invoice;
        this.placaCaminhao = placaCaminhao;
        this.placaCarreta1 = placaCarreta1;
        this.placaCarreta2 = placaCarreta2;
        this.notaFiscal = notaFiscal;
    }

    public Carga(int invoice, Caminhao placaCaminhao, Carreta placaCarreta1, Carreta placaCarreta2, String notaFiscal) {
        this.invoice = invoice;
        this.placaCaminhao = placaCaminhao;
        this.placaCarreta1 = placaCarreta1;
        this.placaCarreta2 = placaCarreta2;
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

    public Caminhao getPlacaCaminhao() {
        return placaCaminhao;
    }

    public Carreta getPlacaCarreta1() {
        return placaCarreta1;
    }

    public Carreta getPlacaCarreta2() {
        return placaCarreta2;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

}
