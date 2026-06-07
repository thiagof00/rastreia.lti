package view.form;

import java.util.Scanner;

import model.Carga;
import model.enums.StatusViagem;
import util.*;

public class CargaFormView {

    Scanner Input = new Scanner(System.in);

    public Carga formularioCadastroCarga() {

        System.out.println("========== CADASTRO DE CARGA ==========");
        try {

            System.out.print("Invoice (número): ");
            int invoice = Integer.parseInt(Input.nextLine());

            System.out.print("\nNota fiscal: ");
            String notaFiscal = Input.nextLine();

            System.out.print("\nPO: ");
            String PO = Input.nextLine();

            System.out.print("\nOrigem: ");
            String origem = Input.nextLine();

            System.out.print("\nDestino: ");
            String destino = Input.nextLine();
            System.out.println();

            String localidade = origem;
            Carga novacarga = new Carga(invoice, PO, notaFiscal, origem, localidade, destino, StatusViagem.PENDENTE);
            return novacarga;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro no preenchimento dos dados.");
            AguardarVoltar.Voltar();
            return null;
        }
    }
}