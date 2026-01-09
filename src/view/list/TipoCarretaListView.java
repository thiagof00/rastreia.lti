package view.list;

import java.util.List;

import model.TipoCarreta;
import util.aguardarVoltar;

public class TipoCarretaListView {
    public void listarTiposCarretas(List<TipoCarreta> tipoCarretas) {
        System.out.println("\n========== LISTA DE TIPO DE CARRETAS ==========");

        if (tipoCarretas.isEmpty()) {
            System.out.println("Nenhum tipo de carreta cadastrado.");
            aguardarVoltar.Voltar();
            return;
        }

        System.out.printf("%-4s | %-15s | %s | %-15s%n","ID", "TIPO","CAPACIDADE","Quantidade de Placas");
        System.out.println("-".repeat(53));
        for (TipoCarreta tc : tipoCarretas) {
            System.out.printf(
                    "%-4d | %-15s | %-10s | %-15s%n",
                    tc.getId(),
                    tc.getTipo(),
                    tc.getCapacidade(),
                    tc.getQtdPlacas());
        }
        aguardarVoltar.Voltar();
    }


}
