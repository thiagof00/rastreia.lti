package repository;

import java.util.ArrayList;
import java.util.List;

import model.Motorista;

public class MotoristaRepository {
    private static List<Motorista> motoristas = new ArrayList<>(List.of(
            new Motorista("Carlos Silva", "93128446016", "Ocioso"),
            new Motorista("Ana Souza", "82736455020", "Em Viagem"),
            new Motorista("Marcos Lima", "74583922030", "Em Manutenção")));

    public static void salvar(Motorista motorista) {
        motoristas.add(motorista);
    }

    public static List<Motorista> listar() {
        return motoristas;
    }

}
