package model;

public class EtapasTransporte {

    private int id;
    private Carga carga;
    private Caminhao caminhao;
    private Carreta carreta;
    private Carreta carreta2;
    private Motorista motorista;
    private String status;
    private String origem;
    private String destino;



    
    public EtapasTransporte(int id, Carga carga, Caminhao caminhao, Carreta carreta, Carreta carreta2, Motorista motorista, String origem, String destino, String status) {
        this.id = id;
        this.carga = carga;
        this.caminhao = caminhao;
        this.carreta = carreta;
        this.carreta2 = carreta2;
        this.motorista = motorista;
        this.origem = origem;
        this.destino = destino;
        this.status = status;
    }

    public EtapasTransporte( Carga carga, Caminhao caminhao, Carreta carreta, Carreta carreta2, Motorista motorista, String origem, String destino, String status) {
        this.carga = carga;
        this.caminhao = caminhao;
        this.carreta = carreta;
        this.carreta2 = carreta2;
        this.motorista = motorista;
        this.origem = origem;
        this.destino = destino;
        this.status = status;
    }

    public EtapasTransporte(int id, Carga carga, Caminhao caminhao, Carreta carreta, Motorista motorista, String origem, String destino, String status) {
        this.id = id;
        this.carga = carga;
        this.caminhao = caminhao;
        this.carreta = carreta;
        this.motorista = motorista;
        this.origem = origem;
        this.destino = destino;
        this.status = status;
    }
    public EtapasTransporte( Carga carga, Caminhao caminhao, Carreta carreta, Motorista motorista, String origem, String destino, String status) {
        this.carga = carga;
        this.caminhao = caminhao;
        this.carreta = carreta;
        this.motorista = motorista;
        this.origem = origem;
        this.destino = destino;
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
    
    public String getOrigem(){
        return origem;
    }

    public String getDestino() {
    return destino;
    }

    public String getStatus() {
    return status;
    }
    

}
