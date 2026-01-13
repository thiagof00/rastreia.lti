package repository;

import java.util.ArrayList;
import java.util.List;

import model.Motorista;

public class MotoristaRepository {
    private static List<Motorista> motoristas = new ArrayList<>(List.of(
            new Motorista(1, "Carlos Silva", "93128446016", "Em Viagem"),
            new Motorista(2, "Ana Souza", "82736455020", "Em Viagem"),
            new Motorista(3, "Marcos Lima", "74583922030", "Em Viagem"),
            new Motorista(4, "Gerson Anderson", "18118185010", "Ocioso"),
            new Motorista(5, "Benildo Matheus", "18212543099", "Indisponivel")));
    private static int id = 6;

    public static void salvar(Motorista motorista) {
        motorista.setId(id++);
        motoristas.add(motorista);
    }

    public static boolean excluir(String cpf) {
        return motoristas.removeIf(mot -> mot.getCpf().equals(cpf));

    }

    public static List<Motorista> listar() {
        return motoristas;
    }

}