package view.list;

import java.util.List;
import model.Carga;
import util.aguardarVoltar;
import model.EtapasTransporte;

public class EtapasTransporteListView {

    public void listarEtapas(List<EtapasTransporte> etapas) {
        System.out.println("\n========== LISTA DE ETAPAS ==========");
        if (etapas.isEmpty()) {
            System.out.println("Nenhuma carga cadastrada.");
            aguardarVoltar.Voltar();
            return;
        }

        
        System.out.println("-".repeat(96));
        for (EtapasTransporte e : etapas) {
            Carga c = e.getCarga();
            System.out.printf(
                    "%d | %d | %s | %s | %s | %s | %s | %s | %s | %s%n",
                    e.getId(),
                    c.getInvoice(),
                    c.getPO(),
                    c.getNotaFiscal(),
                    c.getOrigem(),
                    c.getDestino(),
                    e.getCaminhao().getPlaca(),
                    e.getCarreta().getPlaca(),
                    e.getCarreta2().getPlaca(),
                    e.getStatus());
        }

        aguardarVoltar.Voltar();
    }
}
