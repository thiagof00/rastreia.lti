package view.update;

import java.util.List;
import java.util.Scanner;
import model.Carga;
import model.EtapasTransporte;
import model.enums.StatusMotorista;
import model.enums.StatusVeiculo;
import repository.EtapasTransporteRepository;
import util.Limpar;
import util.AguardarVoltar;

public class CargaStatusUpdateView {

    Scanner input = new Scanner(System.in);
    List<EtapasTransporte> etapas = EtapasTransporteRepository.listar();
    int id;
    EtapasTransporte etapaSelecionada;

    public Carga updateStatusCarga(List<Carga> cargas) {
        System.out.println("\n========== LISTA DE CARGAS ==========");
        if (cargas.isEmpty()) {
            System.out.println("Nenhuma carga cadastrada.");
            AguardarVoltar.Voltar();
            return null;
        }

        System.out.printf("\n%-4s | %-8s | %-13s | %-11s | %-15s | %-15s | %-15s | %-12s\n", "ID", "INVOICE", "PO",
                "NOTA FISCAL",
                "ORIGEM", "LOCALIDADE", "DESTINO", "STATUS");
        System.out.println("-".repeat(96));
        for (Carga c : cargas) {
            System.out.printf(
                    "%-4d | %-8d | %-13s | %-11s | %-15s | %-15s | %-15s | %-12s\n",
                    c.getId(),
                    c.getInvoice(),
                    c.getPO(),
                    c.getNotaFiscal(),
                    c.getOrigem(),
                    c.getLocalidade(),
                    c.getDestino(),
                    c.getStatus());
        }

        System.out.print("\nDigite o ID da carga que deseja atualizar o status (0 para cancelar): ");
        id = Integer.parseInt(input.nextLine());

        Limpar.terminal();

        System.out.printf(
                "%-4s | %-8s | %-10s | %-7s | %-14s | %-14s | %-14s | %-14s | %-9s | %-10s | %-10s | %-10s | %-12s\n",
                "ID", "Invoice", "PO", "NF", "Origem", "Localidade", "Prox Parada", "Destino", "Caminhão", "Carreta 1",
                "Carreta 2", "Motorista", "Status");
        System.out.println("-".repeat(160));

        for (EtapasTransporte e : etapas) {
            Carga c = e.getCarga();

            if (id == c.getId()) {
                etapaSelecionada = e;
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
        System.out.println("\nDeseja atualizar o status da carga para 'Concluída'? ");
        System.out.println("1 - Sim");
        System.out.println("0 - Não (Cancelar)");
        int escolhaAlterar = Integer.parseInt(input.nextLine());

        if (escolhaAlterar != 1) {
            return null;
        } else {
            setStatus();
            if (etapaSelecionada.getCarreta2() != null) {
                return new Carga(etapaSelecionada.getInvoice(), etapaSelecionada.getMotorista(),
                        etapaSelecionada.getCaminhao(), etapaSelecionada.getCarreta(), etapaSelecionada.getCarreta2(),
                        etapaSelecionada.getPO(), etapaSelecionada.getNotaFiscal(),
                        etapaSelecionada.getCarga().getOrigem(),
                        etapaSelecionada.getCarga().getDestino(), "-", etapaSelecionada.getCarga().getDestino(),
                        "Concluída");

            } else {

                return new Carga(etapaSelecionada.getInvoice(), etapaSelecionada.getMotorista(),
                        etapaSelecionada.getCaminhao(),
                        etapaSelecionada.getCarreta(), etapaSelecionada.getPO(), etapaSelecionada.getNotaFiscal(),
                        etapaSelecionada.getCarga().getOrigem(),
                        etapaSelecionada.getCarga().getDestino(), "-", etapaSelecionada.getCarga().getDestino(),
                        "Concluída");

            }
        }

    }

    private void setStatus() {

        etapaSelecionada.getMotorista().setStatus(StatusMotorista.OCIOSO);
        etapaSelecionada.getCaminhao().setStatus(StatusVeiculo.OCIOSO);
        etapaSelecionada.getCarreta().setStatus(StatusVeiculo.OCIOSO);
        if (etapaSelecionada.getCarreta2() != null) {
            etapaSelecionada.getCarreta2().setStatus(StatusVeiculo.OCIOSO);
        }
    }
}
