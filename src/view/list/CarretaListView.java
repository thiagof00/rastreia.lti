package view.list;

import java.util.List;

import model.Carreta;
import util.*;

public class CarretaListView {

    public void listarCarretas(List<Carreta> carretas) {
        System.out.println("========== LISTA DE CARRETAS ==========");
        if (carretas.isEmpty()) {
            System.out.println("Nenhuma carreta cadastrada.");
            aguardarVoltar.Voltar();
            return;
        }

        System.out.printf("%-4s | %-12s | %-12s | %-14s | %-15s%n", "ID", "PLACA", "TIPO", "PESO MAX", "METRAGEM", "STATUS");
        System.out.println("-".repeat(69));
        for (Carreta c : carretas) {
            System.out.printf(
                    "%-4d | %-12s | %-12s | %-6d | %-6d | %-15s%n",
                    c.getId(),
                    c.getPlaca(),
                    c.getTipo(),
                    c.getPeso_max(),
                    c.getMetragem(),
                    c.getStatus());
        }
        aguardarVoltar.Voltar();
    }
}
