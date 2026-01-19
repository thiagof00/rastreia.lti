package view.form;

import java.util.Scanner;
import model.Caminhao;
import util.*;

public class CaminhaoFormView {

    Scanner input = new Scanner(System.in);

    public Caminhao formularioCadastroCaminhao() {
        System.out.println("========== CADASTRO DE CAMINHÃO ==========");
        try {
            System.out.print("Placa: ");
            String placa = input.nextLine();

            System.out.print("Tipo: ");
            String tipo = input.nextLine();
            String status = "";
            boolean statusValido = false;
            while (!statusValido) {
                System.out.println("\nStatus da Carreta:");
                System.out.println("1 - Ocioso");
                System.out.println("2 - Em Manutenção");
                System.out.println("3 - Em Viagem");
                System.out.print("Escolha uma opção: ");

                int opcao = Integer.parseInt(input.nextLine());

                switch (opcao) {
                    case 1:
                        status = "Ocioso";
                        statusValido = true;
                        break;
                    case 2:
                        status = "Em Manutenção";
                        statusValido = true;
                        break;
                    case 3:
                        status = "Em viagem";
                        statusValido = true;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
            return new Caminhao(placa, tipo, status);

        } catch (Exception e) {
            System.out.println("Erro no preenchimento dos dados.");
            aguardarVoltar.Voltar();
            return null;
        }
    }
}
