package repository;

import java.util.ArrayList;
import java.util.List;
import model.Caminhao;

public class CaminhaoRepository {

    private static List<Caminhao> caminhoes = new ArrayList<>(List.of(
            new Caminhao(1,"MNO2P34", "Volvo", "Em Viagem"),
            new Caminhao(2,"QRS5T67", "Scania", "Em Viagem"),
            new Caminhao(3,"TUV8901", "Mercedes-Benz", "Em Viagem"),
            new Caminhao(4,"IAE5715", "Scania", "Ocioso"),
            new Caminhao(5, "JUQ4774", "Daf", "Em Manutenção")));
    private static int id = 6;
    
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
