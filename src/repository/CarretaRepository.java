package repository;

import java.util.ArrayList;
import java.util.List;

import model.Carreta;

public class CarretaRepository {
    private static List<Carreta> carretas = new ArrayList<>(List.of(
            new Carreta("XYZ1K23", "", 
            TipoCarretaRepository.listar().get(0),
             "Ocioso"),

            new Carreta("ABC4J56", "", 
            TipoCarretaRepository.listar().get(1),
             "Em Manutenção"),

             
            new Carreta("DEF7389", "ICD1240", 
            TipoCarretaRepository.listar().get(2),
             "Em Uso")));

    public static void salvar(Carreta carreta) {
        carretas.add(carreta);
    }

    public static List<Carreta> listar() {
        return carretas;
    }
}
