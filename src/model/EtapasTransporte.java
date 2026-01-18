package model;

public class EtapasTransporte {

    private int id;
    private Carga carga;
    private Caminhao caminhao;
    private Carreta carreta;
    private Carreta carreta2;
    private Motorista motorista;
    private String status;
    private String localidade;
    private String proximaParada;



    
    public EtapasTransporte(int id, Carga carga, Caminhao caminhao, Carreta carreta, Carreta carreta2, Motorista motorista, String localidade, String proximaParada, String status) {
        this.id = id;
        this.carga = carga;
        this.caminhao = caminhao;
        this.carreta = carreta;
        this.carreta2 = carreta2;
        this.motorista = motorista;
        this.localidade = localidade;
        this.proximaParada = proximaParada;
        this.status = status;
    }

    public EtapasTransporte( Carga carga, Caminhao caminhao, Carreta carreta, Carreta carreta2, Motorista motorista, String localidade, String proximaParada, String status) {
        this.carga = carga;
        this.caminhao = caminhao;
        this.carreta = carreta;
        this.carreta2 = carreta2;
        this.motorista = motorista;
        this.localidade = localidade;
        this.proximaParada = proximaParada;
        this.status = status;
    }

    public EtapasTransporte(int id, Carga carga, Caminhao caminhao, Carreta carreta, Motorista motorista, String localidade, String proximaParada, String status) {
        this.id = id;
        this.carga = carga;
        this.caminhao = caminhao;
        this.carreta = carreta;
        this.motorista = motorista;
        this.localidade = localidade;
        this.proximaParada = proximaParada;
        this.status = status;
    }
    public EtapasTransporte( Carga carga, Caminhao caminhao, Carreta carreta, Motorista motorista, String localidade, String proximaParada, String status) {
        this.carga = carga;
        this.caminhao = caminhao;
        this.carreta = carreta;
        this.motorista = motorista;
        this.localidade = localidade;
        this.proximaParada = proximaParada;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Carga getCarga(){
        return carga;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public Caminhao getCaminhao() {
        return caminhao;
    }

    public Carreta getCarreta() {
        return carreta;
    }

    public Carreta getCarreta2() {
        return carreta2;
    }
    
    public String getLocalidade(){
        return localidade;
    }

    public String getProximaParada() {
    return proximaParada;
    }

    public String getStatus() {
    return status;
    }
    public void setLocalidade(String novaLocalidade){
        this.localidade = novaLocalidade;
    }

}
