package repository;

import java.util.ArrayList;
import java.util.List;

import model.Motorista;

public class MotoristaRepository {
    private static List<Motorista> motoristas = new ArrayList<>(List.of(
            new Motorista(1, "Carlos Silva", "93128446016", "Ocioso"),
            new Motorista(2, "Ana Souza", "82736455020", "Em Viagem"),
            new Motorista(3, "Marcos Lima", "74583922030", "Em Manutenção")));
    private static int id = 4;

    public static void salvar(Motorista motorista) {
        motorista.setId(id++);
        motoristas.add(motorista);
    }

    public static List<Motorista> listar() {
        return motoristas;
    }

}
