package view.update;

import java.util.List;
import java.util.Scanner;

import model.Carga;
import model.EtapasTransporte;
import repository.EtapasTransporteRepository;
import util.aguardarVoltar;

public class CargaUpdateView {
    
        Scanner input = new Scanner(System.in);

        

    public Carga updateCarga(List<Carga> cargas){

        System.out.println("\n========== LISTA DE CARGAS ==========");
        if (cargas.isEmpty()) {
            System.out.println("Nenhuma carga cadastrada.");
            aguardarVoltar.Voltar();
            return null;
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

        System.out.println("Digite a carga para alterar");
        int escolhaCarga = Integer.parseInt(input.nextLine());
        
        System.out.printf(
                "%-4s | %-8s | %-10s | %-7s | %-14s | %-14s | %-14s | %-14s | %-9s | %-10s | %-10s | %-12s\n", "ID", "Invoice", "PO", "NF", "Origem", "Localidade", "Prox Parada", "Destino", "Caminhão", "Carreta 1", "Carreta 2", "Status");
        System.out.println("-".repeat(150));
        
        List<EtapasTransporte> etapas = EtapasTransporteRepository.listar();

        for (int i = etapas.size() - 1; i >= 0; i--) {
        EtapasTransporte e = etapas.get(i);
        Carga c = e.getCarga();

        if (c.getId() == escolhaCarga) {
            System.out.printf(
                "%-4s | %-8s | %-10s | %-7s | %-14s | %-14s | %-14s | %-14s | %-9s | %-10s | %-10s | %-12s\n", 
                "ID", "Invoice", "PO", "NF", "Origem", "Localidade", "Prox Parada", "Destino", "Caminhão", "Carreta 1", "Carreta 2", "Status");
            System.out.println("-".repeat(150));

            String placaCarreta2;
             if(c.getCarreta2() != null){
                    placaCarreta2 = c.getCarreta2().getPlaca();
                }else{
                    placaCarreta2 = "—"; }

            System.out.printf(
                "%-4d | %-8d | %-10s | %-7s | %-14s | %-14s | %-14s | %-14s | %-9s | %-10s | %-10s | %-12s\n",
                e.getId(),
                c.getInvoice(),
                c.getPO(),
                c.getNotaFiscal(),
                c.getOrigem(),
                e.getLocalidade(),
                e.getProximaParada(),
                c.getDestino(),
                e.getCaminhao().getPlaca(),
                e.getCarreta().getPlaca(),
                placaCarreta2,
                e.getStatus());
                break;
        }
    }

        return null;
    }
}

