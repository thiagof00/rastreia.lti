package repository;

import java.util.ArrayList;
import java.util.List;
import model.EtapasTransporte;

public class EtapasTransporteRepository {
    
    private static List<EtapasTransporte> etapasTransportes = new ArrayList<>();
    private static int id = 1;

    public static void salvar(EtapasTransporte etapa) {
        etapa.setId(id++);
        etapasTransportes.add(etapa);
    }

    public static List<EtapasTransporte> listar() {
        return etapasTransportes;
    }
}
