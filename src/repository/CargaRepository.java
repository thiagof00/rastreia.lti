package repository;

import java.util.ArrayList;
import java.util.List;
import model.Carga;

public class CargaRepository {

    private static List<Carga> cargas = new ArrayList<>(List.of(
            new Carga(1,101, "abc1d23", "lol9x45", "", "666666"),
            new Carga(2,102, "xyz4t56", "wow0y78", "", "999999"),
            new Carga(3,103, "def7g89", "fun1z90", "", "123456")));
    private static int id = 4;

    public static void salvar(Carga carga) {
        carga.setId(id++);
        cargas.add(carga);
    }

    public static List<Carga> listar() {
        return cargas;
    }

}
