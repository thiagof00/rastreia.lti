package repository;

import java.util.ArrayList;
import java.util.List;

import model.Carreta;
import model.enums.StatusVeiculo;

public class CarretaRepository {
    private static List<Carreta> carretas = new ArrayList<>(List.of(
            new Carreta("XYZ1K23", "Bau", StatusVeiculo.OCIOSO, 18000, 14),
            new Carreta("MTG8221", "Bau", StatusVeiculo.OCIOSO, 19000, 16),
            new Carreta("MNX7887", "Bau", StatusVeiculo.OCIOSO, 14000, 20),
            new Carreta("ASR4936", "Sider", StatusVeiculo.OCIOSO, 20000, 20),
            new Carreta("ICX1221", "LS", StatusVeiculo.OCIOSO, 15000, 16)

    ));
    private static int proximoId;

    static {
        proximoId = 1;
        for (Carreta c : carretas) {
            c.setId(proximoId++);
        }
    }

    public static void salvar(Carreta carreta) {
        carreta.setId(proximoId++);
        carretas.add(carreta);
    }

    public static List<Carreta> listar() {
        return carretas;
    }

    public static boolean excluir(int id) {
        return carretas.removeIf(car -> car.getId() == id);
    }
}