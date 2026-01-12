package repository;

import java.util.ArrayList;
import java.util.List;

import model.Carreta;

public class CarretaRepository {
    private static List<Carreta> carretas = new ArrayList<>(List.of(
            new Carreta(1, "XYZ1K23", "",
                    TipoCarretaRepository.listar().get(1),
                    "Ocioso"),

            new Carreta(2, "ABC4J56", "",
                    TipoCarretaRepository.listar().get(1),
                    "Em Manutenção"),

            new Carreta(3, "DEF7389", "ICD1240",
                    TipoCarretaRepository.listar().get(2),
                    "Em Uso")));
    private static int id = 4;

    public static void salvar(Carreta carreta) {
        carreta.setId(id++);
        carretas.add(carreta);
    }

    public static List<Carreta> listar() {
        return carretas;
    }
}