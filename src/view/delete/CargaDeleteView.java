package view.delete;

import java.util.List;
import java.util.Scanner;

import model.Carga;

public class CargaDeleteView {
    Scanner Input = new Scanner(System.in);

    public int formularioExcluirCarga(List<Carga> cargas) {

        System.out.println("\n========== LISTA DE Carga ==========");

        System.out.printf("%-4s | %-8s | %-13s | %-11s | %-15s | %-15s | %-12s%n", "ID", "INVOICE", "PO",
                "NOTA FISCAL", "ORIGEM", "DESTINO", "STATUS");
        System.out.println("-".repeat(109));
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

        System.out.println("Digite o ID da carga a ser excluida: ");
        int id = Integer.parseInt(Input.nextLine());

        return id;
}
}