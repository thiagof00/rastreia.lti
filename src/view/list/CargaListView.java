package view.list;

import java.util.List;

import model.Carga;
import util.*;
public class CargaListView {
    
    public void listarCargas(List<Carga> cargas) {
        System.out.println("\n========== LISTA DE CARGAS ==========");

        if (cargas.isEmpty()) {
            System.out.println("Nenhuma carga cadastrada.");
            aguardarVoltar.Voltar();;
            return;
        }

        System.out.printf("%-4s | %-8s | %-10s | %-10s | %-10s | %-10s%n", "ID", "INVOICE", "CAMINHÃO", "CARRET. 1", "CARRET. 2", "NOTA FISCAL");
        System.out.println("-".repeat(71));
        for (Carga c : cargas) {
            System.out.printf(
                    "%-4d |%-8d | %-10s | %-10s | %-10s | %-10s%n",
                    c.getId(),
                    c.getInvoice(),
                    c.getPlacaCaminhao(),
                    c.getPlacaCarga1(),
                    c.getPlacaCarga2(),
                    c.getNotaFiscal());
        }

        aguardarVoltar.Voltar();;
    }
}
