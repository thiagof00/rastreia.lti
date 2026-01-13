package repository;

import java.util.ArrayList;
import java.util.List;

import model.Carreta;

public class CarretaRepository {
    private static List<Carreta> carretas = new ArrayList<>(List.of(
            new Carreta(1, "XYZ1K23", "Bau", "Em Viagem", 18000, 14),
            new Carreta(2, "MTG8221", "Bau", "Em Viagem", 19000, 16),
            new Carreta(3, "MNX7887", "Bau", "Em Viagem", 14000, 20),
            new Carreta(4,"ASR4936", "Sider", "Ocioso", 20000, 20),
            new Carreta(5,"ICX1221", "LS", "Em manutenção", 15000, 16)
            
));
    private static int id = 6;

    public static void salvar(Carreta carreta) {
        carreta.setId(id++);
        carretas.add(carreta);
    }

    public static List<Carreta> listar() {
        return carretas;
    }

    public static boolean excluir(int id) {
        return carretas.removeIf(car -> car.getId() == id);
    }  
}