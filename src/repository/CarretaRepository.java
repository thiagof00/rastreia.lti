package repository;

import java.util.ArrayList;
import java.util.List;

import model.Carreta;

public class CarretaRepository {
    private static List<Carreta> carretas = new ArrayList<>(List.of(
            new Carreta("XYZ1K23", "", "Sider", "Ocioso"),
            new Carreta("ABC4J56", "", "Baú", "Em Manutenção"),
            new Carreta("DEF7389", "ICD1240", "Bitrem", "Em Uso")));

    public static void salvar(Carreta carreta) {
        carretas.add(carreta);
    }

    public static List<Carreta> listar() {
        return carretas;
    }
}
