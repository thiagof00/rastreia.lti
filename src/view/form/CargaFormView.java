package view.form;

import java.util.Scanner;

import model.Carga;
import util.*;

public class CargaFormView {

    Scanner input = new Scanner(System.in);

    public Carga formularioCadastroCarga() {
        System.out.println("========== CADASTRO DE CARGA ==========");

        try {
            System.out.print("Invoice (número): ");
            int invoice = Integer.parseInt(input.nextLine());

            System.out.print("Placa do caminhão: ");
            String placaCaminhao = input.nextLine();

            System.out.print("Placa 1 da carga: ");
            String placaCarga1 = input.nextLine();

            System.out.print("Placa 2 da carga: ");
            String placaCarga2 = input.nextLine();

            System.out.print("Nota fiscal: ");
            String notaFiscal = input.nextLine();

            return new Carga(invoice, placaCaminhao, placaCarga1, placaCarga2, notaFiscal);
            

        } catch (Exception e) {
            System.out.println("Erro no preenchimento dos dados.");
            aguardarVoltar.Voltar();
            return null;
        }
    }
}