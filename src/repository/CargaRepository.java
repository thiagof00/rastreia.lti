package repository;

import java.util.ArrayList;
import java.util.List;
import model.Carga;

public class CargaRepository {

    private static List<Carga> cargas = new ArrayList<>(List.of());

    private static int proximoId = 1;

    public static void salvar(Carga carga) {
        carga.setId(proximoId++);
        cargas.add(carga);
    }

    public static List<Carga> listar() {
        return cargas;
    }

}