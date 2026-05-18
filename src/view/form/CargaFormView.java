package view.form;

import java.util.Scanner;

import model.Carga;
import model.Carreta;
import model.EtapasTransporte;
import model.enums.StatusViagem;
import util.*;

public class CargaFormView {

    Scanner input = new Scanner(System.in);

    public Carga formularioCadastroCarga() {

        System.out.println("========== CADASTRO DE CARGA ==========");
        try {

            System.out.print("Invoice (número): ");
            int invoice = Integer.parseInt(input.nextLine());

            System.out.print("\nNota fiscal: ");
            String notaFiscal = input.nextLine();

            System.out.print("\nPO: ");
            String PO = input.nextLine();

            System.out.print("\nOrigem: ");
            String origem = input.nextLine();

            System.out.print("\nDestino: ");
            String destino = input.nextLine();
            System.out.println();

            String localidade = origem;
            Carga novacarga = new Carga(invoice, PO, notaFiscal, origem, localidade, destino, StatusViagem.EM_VIAGEM);
            return novacarga;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro no preenchimento dos dados.");
            AguardarVoltar.Voltar();
            return null;
        }
    }
}