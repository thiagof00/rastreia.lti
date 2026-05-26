package repository;

import java.util.ArrayList;
import java.util.List;
import model.Caminhao;
import model.Carga;
import model.enums.StatusVeiculo;

public class CaminhaoRepository {

    private static final List<Caminhao> caminhoes = new ArrayList<>(List.of(
            new Caminhao("MNO2P34", "Volvo", StatusVeiculo.OCIOSO),
            new Caminhao("QRS5T67", "Scania", StatusVeiculo.OCIOSO),
            new Caminhao("TUV8901", "Mercedes-Benz", StatusVeiculo.OCIOSO),
            new Caminhao("IAE5715", "Scania", StatusVeiculo.OCIOSO),
            new Caminhao("JUQ4774", "Daf", StatusVeiculo.OCIOSO)));

    private static int proximoId;

    static {
        proximoId = 1;
        for (Caminhao c : caminhoes) {
            c.setId(proximoId++);
        }
    }

    public static void salvar(Caminhao caminhao) {
        caminhao.setId(proximoId++);
        caminhoes.add(caminhao);
    }

    public static List<Caminhao> listar() {
        return caminhoes;
    }

    public static boolean excluir(int id) {
        return caminhoes.removeIf(cam -> cam.getId() == id);
    }

    public static Caminhao getCaminhaoPorId(int id) {
        for (Caminhao c : caminhoes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
}