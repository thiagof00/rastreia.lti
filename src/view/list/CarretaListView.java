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

        System.out.printf("%-4s | %-12s | %-12s | %-14s | %-15s%n", "ID", "PLACA 1", "PLACA 2", "TIPO", "STATUS");
        System.out.println("-".repeat(69));
        for (Carreta c : carretas) {
            System.out.printf(
                    "%-4d | %-12s | %-12s | %-14s | %-15s%n",
                    c.getId(),
                    c.getPlaca1(),
                    c.getPlaca2(),
                    c.getTipoCarreta().getTipo(),
                    c.getStatus());
        }
        aguardarVoltar.Voltar();
    }
}
