package repository;

import java.util.ArrayList;
import java.util.List;

import model.TipoCarreta;

public class TipoCarretaRepository {
    private static List<TipoCarreta> tipoCarretas = new ArrayList<>(List.of(
            new TipoCarreta(1,"Sider", 20000, 1),
            new TipoCarreta(2,"Baú", 15000, 1),
            new TipoCarreta(3,"Bitrem", 30000, 2)));
    private static int id = 4;

    public static void salvar(TipoCarreta tipoCarreta) {
        tipoCarreta.setId(id++);
        tipoCarretas.add(tipoCarreta);
    }

    public static List<TipoCarreta> listar() {
        return tipoCarretas;
    }
}
