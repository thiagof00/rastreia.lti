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

        System.out.printf("%-4s | %-8s | %-10s | %-10s | %-10s | %-10s | %-12s%n", "ID", "INVOICE", "CAMINHÃO", "CARRET. 1",
                "CARRET. 2", "NOTA FISCAL", "STATUS");
        System.out.println("-".repeat(82));
        for (Carga c : cargas) {
            System.out.printf(
                    "%-4d | %-8d | %-10s | %-10s | %-10s | %-10s | %-12s%n",
                    c.getId(),
                    c.getInvoice(),
                    c.getPlacaCaminhao().getPlaca(),
                    c.getPlacaCarreta1().getPlaca1(),
                    c.getPlacaCarreta2().getPlaca2(),
                    c.getNotaFiscal(),
                    c.getStatus());
        }

        aguardarVoltar.Voltar();
    }
}
