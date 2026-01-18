package view.list;

import java.util.List;
import model.Carga;
import model.EtapasTransporte;
import util.aguardarVoltar;

public class EtapasTransporteListView {

    public void listarEtapas(List<EtapasTransporte> etapas, int id) {
        System.out.println("\n========== LISTA DE ETAPAS ==========");

        if (etapas.isEmpty()) {
            System.out.println("Nenhuma etapa cadastrada.");
            aguardarVoltar.Voltar();
            return;
        }
        System.out.printf(
                "%-4s | %-8s | %-10s | %-7s | %-14s | %-14s | %-14s | %-14s | %-9s | %-10s | %-10s | %-10s | %-12s\n",
                "ID", "Invoice", "PO", "NF", "Origem", "Localidade", "Prox Parada", "Destino", "Caminhão", "Carreta 1",
                "Carreta 2", "Motorista", "Status");
        System.out.println("-".repeat(150));

        for (EtapasTransporte e : etapas) {
            Carga c = e.getCarga();

            if (id == c.getId()) {

                String placaCarreta2;
                if (e.getCarreta2() != null) {
                    placaCarreta2 = e.getCarreta2().getPlaca();
                } else {
                    placaCarreta2 = "—";
                }
                System.out.printf(

                        "\n%-4d | %-8d | %-10s | %-7s | %-14s | %-14s | %-14s | %-14s | %-9s | %-10s | %-10s | %-10s | %-12s\n",
                        e.getId(),
                        e.getInvoice(),
                        e.getPO(),
                        e.getNotaFiscal(),
                        e.getCarga().getOrigem(),
                        e.getLocalidade(),
                        e.getProximaParada(),
                        e.getCarga().getDestino(),
                        e.getCaminhao().getPlaca(),
                        e.getCarreta().getPlaca(),
                        placaCarreta2,
                        e.getMotorista().getNome(),
                        e.getStatus());
            }
        }

        aguardarVoltar.Voltar();
    }
}
