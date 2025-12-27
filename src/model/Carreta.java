package model;

public class Carreta {
    private String placa1;
    private String placa2;
    private String tipoCarreta;
    private String StatusCarreta;

    public Carreta(String placa1, String placa2, String tipoCarreta, String StatusCarreta) {
        this.placa1 = placa1;
        this.placa2 = placa2;
        this.tipoCarreta = tipoCarreta;
        this.StatusCarreta = StatusCarreta;
    }

    public String getPlaca1() {
        return placa1;
    }

    public String getPlaca2() {
        return placa2;
    }

    public String getTipoCarreta() {
        return tipoCarreta;
    }

    public String getStatusCarreta() {
        return StatusCarreta;
    }
}
