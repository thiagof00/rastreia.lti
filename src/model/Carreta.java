package model;

public class Carreta {
    private String placa1;
    private String placa2;
    private TipoCarreta tipoCarreta;
    private String statusCarreta;
    private int id;

    public Carreta(int id, String placa1, String placa2, TipoCarreta tipoCarreta, String statusCarreta) {
        this.id = id;
        this.placa1 = placa1;
        this.placa2 = placa2;
        this.tipoCarreta = tipoCarreta;
        this.statusCarreta = statusCarreta;
    }

    public Carreta(String placa1, String placa2, TipoCarreta tipoCarreta, String statusCarreta) {
        this.placa1 = placa1;
        this.placa2 = placa2;
        this.tipoCarreta = tipoCarreta;
        this.statusCarreta = statusCarreta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca1() {
        return placa1;
    }

    public String getPlaca2() {
        return placa2;
    }

    public TipoCarreta getTipoCarreta() {
        return tipoCarreta;
    }

    public String getStatus() {
        return statusCarreta;
    }

    public void setStatus(String statusCarreta) {
        this.statusCarreta = statusCarreta;
    }
}
