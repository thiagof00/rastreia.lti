package repository;

import java.util.ArrayList;
import java.util.List;

import model.Carreta;

public class CarretaRepository {
    private static List<Carreta> carretas = new ArrayList<>(List.of(
            new Carreta(1, "XYZ1K23", "Bau", "Ocioso", 18000, 14),
            new Carreta(2, "MTG8221", "Bau", "Ocioso", 19000, 16),
            new Carreta(3, "MNX7887", "Bau", "Ocioso", 14000, 20)
            
));
    private static int id = 4;

    public static void salvar(Carreta carreta) {
        carreta.setId(id++);
        carretas.add(carreta);
    }

    public static List<Carreta> listar() {
        return carretas;
    }
}