package repository;

import java.util.ArrayList;
import java.util.List;
import model.Caminhao;

public class CaminhaoRepository {

    private static List<Caminhao> caminhoes = new ArrayList<>(List.of(
            new Caminhao("MNO2P34", "Volvo", "Ocioso"),
            new Caminhao("QRS5T67", "Scania", "Em Manutenção"),
            new Caminhao("TUV8901", "Mercedes-Benz", "Em Uso")));

    public static void salvar(Caminhao caminhao) {
        caminhoes.add(caminhao);
    }

    public static List<Caminhao> listar() {
        return caminhoes;
    }
}
