package model;

public class EtapasTransporte {

    private int id;
    private Caminhao caminhao;
    private Carreta carreta1;
    private Carreta carreta2;
    private Motorista motorista;
    private String proxParada;
    private String ultimaLocalidade;
    private int idCarga;

    public EtapasTransporte(int idCarga, Motorista motorista, Caminhao caminhao, Carreta carreta1, String proxParada) {
        this.idCarga = idCarga;
        this.motorista = motorista;
        this.caminhao = caminhao;
        this.carreta1 = carreta1;
        this.proxParada = proxParada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCarga() {
        return idCarga;
    }

    public void setIdCarga(int idCarga) {
        this.idCarga = idCarga;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Caminhao getCaminhao() {
        return caminhao;
    }

    public String getUltimaLocalidade() {
        return ultimaLocalidade;
    }

    public String getProxParada() {
        return proxParada;
    }

    public void setCaminhao(Caminhao caminhao) {
        this.caminhao = caminhao;
    }

    public Carreta getCarreta1() {
        return carreta1;
    }

    public void setCarreta1(Carreta carreta1) {
        this.carreta1 = carreta1;
    }

    public Carreta getCarreta2() {
        return carreta2;
    }

    public void setCarreta2(Carreta carreta2) {
        this.carreta2 = carreta2;
    }

    public String getproxParada() {
        return proxParada;
    }

    public void setProxParada(String proxParada) {
        this.proxParada = proxParada;
    }

    public void setUltimaLocalidade(String ultimaLocalidade) {
        this.ultimaLocalidade = ultimaLocalidade;
    }
}
