package repository;

import java.util.ArrayList;
import java.util.List;
import model.Carga;
import model.enums.StatusViagem;

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

    public static List<Carga> listarPendentes(){
        List<Carga> cargasPendentes = new ArrayList<>();
        for (Carga carga : cargas) {
            if (carga.getStatus().equals(StatusViagem.PENDENTE)) {
                cargasPendentes.add(carga);
            }
        }
        return cargasPendentes;
    }

    public static Carga getCargaPorId(int id) {
        for (Carga carga : cargas) {
            if (carga.getId() == id) {
                return carga;
            }
        }
        return null;
    }

    public static boolean excluir(int id) {
        return cargas.removeIf(car -> car.getId() == id);
    }

}