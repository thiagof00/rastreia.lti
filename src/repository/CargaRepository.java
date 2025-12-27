package repository;

import java.util.ArrayList;
import java.util.List;
import model.Carga;

public class CargaRepository {

    private static List<Carga> cargas = new ArrayList<>(List.of(
            new Carga(1, "abc1d23", "lol9x45", "", "666666"),
            new Carga(2, "xyz4t56", "wow0y78", "", "999999"),
            new Carga(3, "def7g89", "fun1z90", "", "123456")));

    public static void salvar(Carga carga) {
        cargas.add(carga);
    }

    public static List<Carga> listar() {
        return cargas;
    }

}
