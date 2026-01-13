package view.form;

import java.util.Scanner;

import model.Carreta;
import util.aguardarVoltar;

public class CarretaFormView {

    Scanner input = new Scanner(System.in);

    public Carreta formularioCadastroCarreta() {

        System.out.println("========== CADASTRO DE CARRETA ==========");

        try {
            System.out.print("Placa da carreta: ");
            String placa = input.nextLine();

            System.out.print("Tipo da carreta: ");
            String tipo = input.nextLine();

            System.out.print("Peso máximo (kg): ");
            int pesoMax = Integer.parseInt(input.nextLine());

            System.out.print("Metragem (em metros): ");
            int metragem = Integer.parseInt(input.nextLine());

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
                        status = "Em Uso";
                        statusValido = true;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }

            return new Carreta(
                    placa,
                    tipo,
                    status,
                    pesoMax,
                    metragem
            );

        } catch (Exception e) {
            System.out.println("Erro no preenchimento dos dados.");
            aguardarVoltar.Voltar();
            return null;
        }
    }
}
