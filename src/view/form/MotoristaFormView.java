package view.form;

import java.util.Scanner;
import model.Motorista;
import model.enums.StatusMotorista;
import util.*;

public class MotoristaFormView {

    Scanner Input = new Scanner(System.in);

    public Motorista formularioCadastroMotorista() {
        System.out.println("========== CADASTRO DE MOTORISTA ==========");
        try {
            System.out.print("Nome: ");
            String nome = Input.nextLine();

            System.out.print("CPF: ");
            String cpf = Input.nextLine();

            StatusMotorista status = StatusMotorista.INDISPONIVEL;
            boolean statusValido = false;

            while (!statusValido) {
                System.out.println("\nStatus da Carreta:");
                System.out.println("1 - Ocioso");
                System.out.println("2 - Indisponivel");
                System.out.println("3 - Em Viagem");
                System.out.print("Escolha uma opção: ");

                int opcao = Integer.parseInt(Input.nextLine());

                switch (opcao) {
                    case 1:
                        status = StatusMotorista.OCIOSO;
                        statusValido = true;
                        break;
                    case 2:
                        status = StatusMotorista.INDISPONIVEL;
                        statusValido = true;
                        break;
                    case 3:
                        status = StatusMotorista.EM_VIAGEM;
                        statusValido = true;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }

            return new Motorista(nome, cpf, status);

        } catch (Exception e) {
            System.out.println("Erro no preenchimento dos dados.");
            AguardarVoltar.Voltar();
            return null;
        }
    }
}
