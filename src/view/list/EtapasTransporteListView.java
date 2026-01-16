package view.list;

import java.util.List;
import model.Carga;
import util.aguardarVoltar;
import model.EtapasTransporte;

public class EtapasTransporteListView {

    public void listarEtapas(List<EtapasTransporte> etapas, int id) {
        System.out.println("\n========== LISTA DE ETAPAS ==========");

        if (etapas.isEmpty()) {
            System.out.println("Nenhuma etapa cadastrada.");
            aguardarVoltar.Voltar();
            return;
        }
        System.out.printf(
                "%-4s | %-8s | %-10s | %-7s | %-14s | %-14s | %-14s | %-14s | %-9s | %-10s | %-10s | %-12s\n", "ID", "Invoice", "PO", "NF", "Origem", "Localidade", "Prox Parada", "Destino", "Caminhão", "Carreta 1", "Carreta 2", "Status");
        System.out.println("-".repeat(150));

        for (EtapasTransporte e : etapas) {
            Carga c = e.getCarga();

            if(id == c.getId()){

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
        }}

        aguardarVoltar.Voltar();
    }
}
