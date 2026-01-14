package view.list;

import java.util.List;

import model.Carga;
import util.*;
public class CargaListView {
    
    public void listarCargas(List<Carga> cargas) {
        System.out.println("\n========== LISTA DE CARGAS ==========");
        if (cargas.isEmpty()) {
            System.out.println("Nenhuma carga cadastrada.");
            aguardarVoltar.Voltar();
            return;
        }

        System.out.printf("%-4s | %-8s | %-13s | %-11s | %-15s | %-15s | %-12s%n", "ID", "INVOICE", "PO", "NOTA FISCAL",
                "ORIGEM", "DESTINO", "STATUS");
        System.out.println("-".repeat(96));
        for (Carga c : cargas) {
            System.out.printf(
                    "%-4d | %-8d | %-13s | %-11s | %-15s | %-15s | %-12s%n",
                    c.getId(),
                    c.getInvoice(),
                    c.getPO(),
                    c.getNotaFiscal(),
                    c.getOrigem(),
                    c.getDestino(),
                    c.getStatus());
        }

        aguardarVoltar.Voltar();
    }
}
