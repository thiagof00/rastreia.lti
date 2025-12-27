package repository;

import java.util.ArrayList;
import java.util.List;

import model.TipoCarreta;

public class TipoCarretaRepository {
    private static List<TipoCarreta> tipoCarretas = new ArrayList<>(List.of(
            new TipoCarreta("Sider", 20000, 1),
            new TipoCarreta("Baú", 15000, 1),
            new TipoCarreta("Bitrem", 30000, 2)));

    public static void salvar(TipoCarreta tipoCarreta) {
        tipoCarretas.add(tipoCarreta);
    }

    public static List<TipoCarreta> listar() {
        return tipoCarretas;
    }
}
