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

            System.out.print("Status: ");
            String status = input.nextLine();

            return new Motorista(nome, cpf, status);

        } catch (Exception e) {
            System.out.println("Erro no preenchimento dos dados.");
            aguardarVoltar.Voltar();
            return null;
        }
    }
}
