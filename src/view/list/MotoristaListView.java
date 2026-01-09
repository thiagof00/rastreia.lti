package view.list;

import java.util.List;

import model.Motorista;
import util.*;

public class MotoristaListView {

    public void listarMotoristas(List<Motorista> motoristas) {
        System.out.println("\n========== LISTA DE MOTORISTAS ==========");

        if (motoristas.isEmpty()) {
            System.out.println("Nenhum motorista cadastrado.");
            aguardarVoltar.Voltar();
            return;
        }

        System.out.printf("%-4s | %-15s | %-15s | %-15s%n", "ID", "NOME", "CPF", "STATUS");
        System.out.println("-".repeat(58));
        for (Motorista m : motoristas) {
            System.out.printf(
                    "%-4d | %-15s | %-15s | %-15s%n",
                    m.getId(),
                    m.getNome(),
                    m.getCpf(),
                    m.getStatus());
        }
        aguardarVoltar.Voltar();
    }
}
