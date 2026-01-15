package repository;

import java.util.ArrayList;
import java.util.List;
import model.Carga;

public class CargaRepository {

    private static List<Carga> cargas = new ArrayList<>(List.of(
            new Carga(1, 101, "PO-12342334", "666666" , "Buenos Aires", "Buenos Aires", "São Paulo" , "Em viagem"),

            new Carga(2, 102, "PO-34544564", "23434" , "Buenos Aires", "Buenos Aires", "São Paulo" , "Em viagem"),
            
            new Carga(3, 103, "PO-12342334", "6457556" , "Buenos Aires", "Buenos Aires",  "São Paulo" , "Em viagem")));
    private static int id = 4;

    public static void salvar(Carga carga) {
        carga.setId(id++);
        cargas.add(carga);
    }

    public static List<Carga> listar() {
        return cargas;
    }

}