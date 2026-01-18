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
    private String destino;
    private String localidade;
    private String proximaParada;
    private String origem;
    private String PO;

    public Carga(int invoice, Motorista motorista, Caminhao caminhao, Carreta carreta1, Carreta carreta2, String PO, String notaFiscal, String origem, String localidade, String proximaParada, String destino, String status) {
        this.invoice = invoice;
        this.motorista = motorista;
        this.caminhao = caminhao;
        this.carreta1 = carreta1;
        this.carreta2 = carreta2;
        this.PO = PO;
        this.notaFiscal = notaFiscal;
        this.origem = origem;
        this.localidade = localidade;
        this.proximaParada = proximaParada;
        this.destino = destino;
        this.status = status;
    }

    public Carga(int invoice, Motorista motorista, Caminhao caminhao, Carreta carreta1, String PO, String notaFiscal, String origem,  String localidade, String proximaParada, String destino, String status) {
        this.invoice = invoice;
        this.motorista = motorista;
        this.caminhao = caminhao;
        this.carreta1 = carreta1;
        this.PO = PO;
        this.notaFiscal = notaFiscal;
        this.origem = origem;
        this.localidade = localidade;
        this.proximaParada = proximaParada;
        this.destino = destino;
        this.status = status;
    }
    public Carga(int id, int invoice, String PO, String notaFiscal, String origem, String localidade, String destino, String status){
        this.id = id;
        this.invoice = invoice;
        this.PO = PO;
        this.notaFiscal = notaFiscal;
        this.origem = origem;
        this.localidade = localidade;
        this.destino = destino;
        this.status = status;
    }
    public Carga(int invoice, String PO, String notaFiscal, String origem, String localidade, String destino, String status){
        this.invoice = invoice;
        this.PO = PO;
        this.notaFiscal = notaFiscal;
        this.origem = origem;
        this.localidade = localidade;
        this.destino = destino;
        this.status = status;
    }

    public Carga(int id, int invoice, Motorista motorista, Caminhao caminhao, Carreta carreta1, Carreta carreta2, String PO, String notaFiscal, String origem, String localidade, String proximaParada, String destino, String status) {
        this.id = id;
        this.invoice = invoice;
        this.motorista = motorista;
        this.caminhao = caminhao;
        this.carreta1 = carreta1;
        this.carreta2 = carreta2;
        this.PO = PO;
        this.notaFiscal = notaFiscal;
        this.origem = origem;
        this.localidade = localidade;
        this.proximaParada = proximaParada;
        this.destino = destino;
        this.status = status;
    }
    public Carga(int id, int invoice, Motorista motorista, Caminhao caminhao, Carreta carreta1, String PO, String notaFiscal, String origem,  String localidade, String proximaParada, String destino, String status) {
        this.id = id;
        this.invoice = invoice;
        this.motorista = motorista;
        this.caminhao = caminhao;
        this.carreta1 = carreta1;
        this.PO = PO;
        this.notaFiscal = notaFiscal;
        this.origem = origem;
        this.localidade = localidade;
        this.proximaParada = proximaParada;
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

    public String getLocalidade(){
        return localidade;
    }

    public void setLocalidade(String novaLocalidade) {
        this.localidade = novaLocalidade;
    }

    public String getproximaParada(){
        return proximaParada;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String novoDestino) {
        this.destino = novoDestino;
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

    public void setNotaFiscal(String novaNotaFiscal) {
        this.notaFiscal = novaNotaFiscal;
    }

    public String getStatus() {
        return status;
    }

}