package repository;

import java.util.ArrayList;
import java.util.List;

import model.Motorista;
import model.enums.StatusMotorista;

public class MotoristaRepository {
    private static List<Motorista> motoristas = new ArrayList<>(List.of(
            new Motorista("Carlos Silva", "93128446016", StatusMotorista.OCIOSO),
            new Motorista("Ana Souza", "82736455020", StatusMotorista.OCIOSO),
            new Motorista("Marcos Lima", "74583922030", StatusMotorista.OCIOSO),
            new Motorista("Gerson Anderson", "18118185010", StatusMotorista.OCIOSO),
            new Motorista("Benildo Matheus", "18212543099", StatusMotorista.OCIOSO)));
    private static int proximoId;

    static {
        proximoId = 1;

        for (Motorista motorista : motoristas) {
            motorista.setId(proximoId++);
        }
    }

    public static void salvar(Motorista motorista) {
        motorista.setId(proximoId++);
        motoristas.add(motorista);
    }

    public static boolean excluir(String cpf) {
        return motoristas.removeIf(mot -> mot.getCpf().equals(cpf));

    }

    public static List<Motorista> listar() {
        return motoristas;
    }

     public static Motorista getMotoristaPorId(int id) {
        for (Motorista m : motoristas) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

}