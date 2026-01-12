package model;

public class Carga {

    private int invoice;
    private Caminhao placaCaminhao;
    private Carreta placaCarreta1;
    private Carreta placaCarreta2;
    private String notaFiscal;
    private int id;
    private Motorista motorista;
    private String status;

    public Carga(int id, int invoice, Motorista motorista, Caminhao placaCaminhao, Carreta placaCarreta1,
            Carreta placaCarreta2, String notaFiscal, String status) {
        this.id = id;
        this.invoice = invoice;
        this.motorista = motorista;
        this.placaCaminhao = placaCaminhao;
        this.placaCarreta1 = placaCarreta1;
        this.placaCarreta2 = placaCarreta2;
        this.notaFiscal = notaFiscal;
        this.status = status;
    }

    public Carga(int invoice, Motorista motorista, Caminhao placaCaminhao, Carreta placaCarreta1, Carreta placaCarreta2,
            String notaFiscal, String status) {
        this.invoice = invoice;
        this.motorista = motorista;
        this.placaCaminhao = placaCaminhao;
        this.placaCarreta1 = placaCarreta1;
        this.placaCarreta2 = placaCarreta2;
        this.notaFiscal = notaFiscal;
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

    public Motorista getMotorista() {
        return motorista;
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

    public String getStatus() {
        return status;
    }

}