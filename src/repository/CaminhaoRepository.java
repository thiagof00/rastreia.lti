package repository;

import java.util.ArrayList;
import java.util.List;
import model.Caminhao;

public class CaminhaoRepository {

    private static List<Caminhao> caminhoes = new ArrayList<>(List.of(
            new Caminhao(1,"MNO2P34", "Volvo", "Ocioso"),
            new Caminhao(2,"QRS5T67", "Scania", "Em Manutenção"),
            new Caminhao(3,"TUV8901", "Mercedes-Benz", "Em Uso")));
    private static int id = 4;
    
    public static void salvar(Caminhao caminhao) {
        caminhao.setId(id++);
        caminhoes.add(caminhao);
    }

    public static List<Caminhao> listar() {
        return caminhoes;
    }

    public static boolean excluir(int id) {
        return caminhoes.removeIf(cam -> cam.getId() == id);
    }  
}
