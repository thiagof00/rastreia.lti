package view.form;

import java.util.Scanner;
import model.Motorista;
import util.*;

public class MotoristaFormView {

    Scanner input = new Scanner(System.in);

    public Motorista formularioCadastroMotorista() {
        System.out.println("========== CADASTRO DE MOTORISTA ==========");
        try {
            System.out.print("Nome: ");
            String nome = input.nextLine();

            System.out.print("CPF: ");
            String cpf = input.nextLine();

            String status = "";
            boolean statusValido = false;

            while (!statusValido) {
                System.out.println("\nStatus da Carreta:");
                System.out.println("1 - Ocioso");
                System.out.println("2 - Indisponivel");
                System.out.println("3 - Em Viagem");
                System.out.print("Escolha uma opção: ");

                int opcao = Integer.parseInt(input.nextLine());

                switch (opcao) {
                    case 1:
                        status = "Ocioso";
                        statusValido = true;
                        break;
                    case 2:
                        status = "indisponivel";
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

            return new Motorista(nome, cpf, status);

        } catch (Exception e) {
            System.out.println("Erro no preenchimento dos dados.");
            aguardarVoltar.Voltar();
            return null;
        }
    }
}
