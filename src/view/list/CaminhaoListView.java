package view.list;

import java.util.List;

import model.Caminhao;
import util.*;

public class CaminhaoListView {

    public void listarCaminhoes(List<Caminhao> caminhoes) {
        System.out.println("\n========== LISTA DE CAMINHÕES ==========");

        if (caminhoes.isEmpty()) {
            System.out.println("Nenhum caminhão cadastrado.");
            aguardarVoltar.Voltar();
            return;
        }

        System.out.printf("%-4s | %-12s | %-14s | %-15s%n", "ID", "PLACA", "TIPO", "STATUS");
        System.out.println("-".repeat(54));
        for (Caminhao c : caminhoes) {
            System.out.printf(
                    "%-4d | %-12s | %-14s | %-15s%n",
                    c.getId(),
                    c.getPlaca(),
                    c.getTipo(),
                    c.getStatus());
        }
        aguardarVoltar.Voltar();
    }
}
