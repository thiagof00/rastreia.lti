package repository;

import java.util.ArrayList;
import java.util.List;
import model.Carga;

public class CargaRepository {

    private static List<Carga> cargas = new ArrayList<>(List.of(
            new Carga(1, 101, CaminhaoRepository.listar().get(0), CarretaRepository.listar().get(0),
                    CarretaRepository.listar().get(0), "666666"),

            new Carga(2, 102, CaminhaoRepository.listar().get(1), CarretaRepository.listar().get(1),
                    CarretaRepository.listar().get(1), "999999"),
                    
            new Carga(3, 103, CaminhaoRepository.listar().get(2), CarretaRepository.listar().get(2),
                    CarretaRepository.listar().get(2), "123456")));
    private static int id = 4;

    public static void salvar(Carga carga) {
        carga.setId(id++);
        cargas.add(carga);
    }

    public static List<Carga> listar() {
        return cargas;
    }

}
