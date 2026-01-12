package model;

public class Carga {

    private int invoice;
    private Caminhao caminhao;
    private Carreta carreta1;
    private Carreta carreta2;
    private String notaFiscal;
    private int id;
    private Motorista motorista;
    private String status;

    public Carga(int id, int invoice, Motorista motorista, Caminhao caminhao, Carreta carreta1,
            Carreta carreta2, String notaFiscal, String status) {
        this.id = id;
        this.invoice = invoice;
        this.motorista = motorista;
        this.caminhao = caminhao;
        this.carreta1 = carreta1;
        this.carreta2 = carreta2;
        this.notaFiscal = notaFiscal;
        this.status = status;
    }

    public Carga(int invoice, Motorista motorista, Caminhao caminhao, Carreta carreta1, Carreta carreta2,
            String notaFiscal, String status) {
        this.invoice = invoice;
        this.motorista = motorista;
        this.caminhao = caminhao;
        this.carreta1 = carreta1;
        this.carreta2 = carreta2;
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

    public Caminhao getCaminhao() {
        return caminhao;
    }

    public Carreta getCarreta1() {
        return carreta1;
    }

    public Carreta getCarreta2() {
        return carreta2;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public String getStatus() {
        return status;
    }

}