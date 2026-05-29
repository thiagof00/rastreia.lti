package view.form;

import java.util.Scanner;
import model.Carreta;
import model.enums.StatusVeiculo;
import util.AguardarVoltar;

public class CarretaFormView {

    Scanner Input = new Scanner(System.in);

    public Carreta formularioCadastroCarreta() {

        System.out.println("========== CADASTRO DE CARRETA ==========");

        try {
            System.out.print("Placa da carreta: ");
            String placa = Input.nextLine();

            System.out.print("Tipo da carreta: ");
            String tipo = Input.nextLine();

            System.out.print("Peso máximo (kg): ");
            int pesoMax = Integer.parseInt(Input.nextLine());

            System.out.print("Metragem (em metros): ");
            int metragem = Integer.parseInt(Input.nextLine());

            StatusVeiculo status = StatusVeiculo.INDISPONIVEL;
            boolean statusValido = false;

            while (!statusValido) {
                System.out.println("\nStatus da Carreta:");
                System.out.println("1 - Ocioso");
                System.out.println("2 - Em Manutenção");
                System.out.println("3 - Em Viagem");
                System.out.print("Escolha uma opção: ");

                int opcao = Integer.parseInt(Input.nextLine());

                switch (opcao) {
                    case 1:
                        status = StatusVeiculo.OCIOSO;
                        statusValido = true;
                        break;
                    case 2:
                        status = StatusVeiculo.EM_MANUTENCAO;
                        statusValido = true;
                        break;
                    case 3:
                        status = StatusVeiculo.EM_VIAGEM;
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
                    metragem);

        } catch (Exception e) {
            System.out.println("Erro no preenchimento dos dados.");
            AguardarVoltar.Voltar();
            return null;
        }
    }
}
