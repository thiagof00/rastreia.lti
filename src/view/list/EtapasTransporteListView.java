package view.list;

import java.util.List;
import model.Carga;
import model.EtapasTransporte;
import util.AguardarVoltar;

public class EtapasTransporteListView {

    public void listarEtapas(List<EtapasTransporte> etapas, Carga carga) {
        System.out.println("\n========== LISTA DE ETAPAS ==========");

        if (etapas.isEmpty()) {
            System.out.println("Nenhuma etapa cadastrada.");
            AguardarVoltar.Voltar();
            return;
        }
        System.out.printf(
                "%-4s | %-8s | %-10s | %-7s | %-14s | %-14s | %-14s | %-14s | %-9s | %-10s | %-10s | %-10s | %-12s\n",
                "ID", "Invoice", "PO", "NF", "Origem", "Localidade", "Prox Parada", "Destino", "Caminhão", "Carreta 1",
                "Carreta 2", "Motorista", "Status");
        System.out.println("-".repeat(150));

        for (EtapasTransporte etapa : etapas) {

            String placaCarreta2;
            if (etapa.getCarreta2() != null) {
                placaCarreta2 = etapa.getCarreta2().getPlaca();
            } else {
                placaCarreta2 = "—";
            }
            System.out.printf(

                    "\n%-4d | %-8d | %-10s | %-7s | %-14s | %-14s | %-14s | %-14s | %-9s | %-10s | %-10s | %-10s | %-12s\n",
                    etapa.getId(),
                    carga.getInvoice(),
                    carga.getPO(),
                    carga.getNotaFiscal(),
                    carga.getOrigem(),
                    etapa.getUltimaLocalidade(),
                    etapa.getproxParada(),
                    carga.getDestino(),
                    etapa.getCaminhao().getPlaca(),
                    etapa.getCarreta1().getPlaca(),
                    placaCarreta2,
                    etapa.getMotorista().getNome(),
                    carga.getStatus());

        }

        AguardarVoltar.Voltar();
    }
}
