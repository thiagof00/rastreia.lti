package view.update;

import java.util.Scanner;
import model.Carga;
import model.Carreta;
import model.EtapasTransporte;
import model.enums.StatusViagem;
import util.Limpar;
import util.AguardarVoltar;

public class CargaUpdateView {

    Scanner Input = new Scanner(System.in);
    Carreta carretaSelecionada, carretaSelecionada2;
    int respInvoice;
    String respPO, respNotaFiscal, respOrigem, respLocalidade, respDestino;

    public Carga updateCarga(EtapasTransporte ultimaEtapa, Carga cargaSelecionada) {

        try {
            Limpar.terminal();

            System.out.printf(
                    "%-4s | %-8s | %-10s | %-7s | %-14s | %-14s | %-14s | %-14s | %-9s | %-10s | %-10s | %-12s\n",
                    "ID", "Invoice", "PO", "NF", "Origem", "Localidade", "Prox Parada", "Destino", "Caminhão",
                    "Carreta 1", "Carreta 2", "Status");
            System.out.println("-".repeat(160));

            String placaCarreta2;
            if (ultimaEtapa.getCarreta2() != null) {
                placaCarreta2 = ultimaEtapa.getCarreta2().getPlaca();
            } else {
                placaCarreta2 = "—";
            }

            System.out.printf(
                    "%-4d | %-8d | %-10s | %-7s | %-14s | %-14s | %-14s | %-14s | %-9s | %-10s | %-10s | %-12s\n",
                    cargaSelecionada.getId(),
                    cargaSelecionada.getInvoice(),
                    cargaSelecionada.getPO(),
                    cargaSelecionada.getNotaFiscal(),
                    cargaSelecionada.getOrigem(),
                    cargaSelecionada.getLocalidade(),
                    ultimaEtapa.getproxParada(),
                    cargaSelecionada.getDestino(),
                    ultimaEtapa.getCaminhao().getPlaca(),
                    ultimaEtapa.getCarreta1().getPlaca(),
                    placaCarreta2,
                    cargaSelecionada.getStatus());

            System.out.println("--Tecle 0 para manter o valor atual--");

            System.out.print("Invoice (número): ");
            int invoice = Integer.parseInt(Input.nextLine());

            System.out.print("\nNota fiscal: ");
            String notaFiscal = Input.nextLine();

            System.out.print("\nPO: ");
            String PO = Input.nextLine();

            System.out.print("\nOrigem: ");
            String origem = Input.nextLine();

            respLocalidade = ultimaEtapa.getproxParada();

            System.out.print("\nDestino: ");
            String destino = Input.nextLine();

            if (verificaValores(invoice))
                respInvoice = cargaSelecionada.getInvoice();
            else
                respInvoice = invoice;
            if (verificaValoresString(PO))
                respPO = cargaSelecionada.getPO();
            else
                respPO = PO;
            if (verificaValoresString(notaFiscal))
                respNotaFiscal = cargaSelecionada.getNotaFiscal();
            else
                respNotaFiscal = notaFiscal;
            if (verificaValoresString(origem))
                respOrigem = cargaSelecionada.getOrigem();
            else
                respOrigem = origem;

            if (verificaValoresString(destino))
                respDestino = cargaSelecionada.getDestino();
            else
                respDestino = destino;

            return new Carga(respInvoice, respPO, respNotaFiscal, respOrigem, respLocalidade, respDestino,
                    StatusViagem.EM_VIAGEM);

        } catch (Exception e) {
            System.out.println("Erro no preenchimento dos dados. ");
            AguardarVoltar.Voltar();
            return null;
        }
    }

    private boolean verificaValores(int valor) {

        if (valor == 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean verificaValoresString(String valor) {

        if (valor.equals("0")) {
            return true;
        } else {
            return false;
        }
    }

}
